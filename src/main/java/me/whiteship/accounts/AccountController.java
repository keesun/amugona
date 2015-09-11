package me.whiteship.accounts;

import me.whiteship.commons.ErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Keesun Baik
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/accounts", method = POST)
    public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create create,
                                            BindingResult result) {
        if (result.hasErrors()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("잘못된 요청입니다.");
            errorResponse.setCode("bad.request");
            // TODO BindingResult 안에 들어있는 에러 정보 사용하기.
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Account newAccount = service.createAccount(create);
        return new ResponseEntity<>(modelMapper.map(newAccount, AccountDto.Response.class),
                HttpStatus.CREATED);
    }

    // TODO stream() vs parallelStream()
    // TODO HATEOAS
    // TODO 뷰
    // TODO boot를 프로덕션에 배포할때 튜닝포인트(?) 궁금해요~ ^^ (강대권)
    // NSPA 1. Thymeleaf
    // SPA 2. 앵귤러 3. 리액트
    @RequestMapping(value = "/accounts", method = GET)
    @ResponseStatus(HttpStatus.OK)
    public PageImpl<AccountDto.Response> getAccounts(Pageable pageable) {
        Page<Account> page = repository.findAll(pageable);
        List<AccountDto.Response> content = page.getContent().parallelStream()
                .map(account -> modelMapper.map(account, AccountDto.Response.class))
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    @RequestMapping(value = "/accounts/{id}", method = GET)
    @ResponseStatus(HttpStatus.OK)
    public AccountDto.Response getAccount(@PathVariable Long id) {
        Account account = service.getAccount(id);
        return modelMapper.map(account, AccountDto.Response.class);
    }

    // 전체 업데이트: PUT
    // - (password:"pass", fullName:null)

    // 부분 업데이트: PATCH
    // - (username:"whiteship")
    // - (password:"pass")
    // - (username:"whiteship", password:"pass")
    @RequestMapping(value = "/accounts/{id}", method = PUT)
    public ResponseEntity updateAccount(@PathVariable Long id,
                                        @RequestBody @Valid AccountDto.Update updateDto,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account updatedAccount = service.updateAccount(id, updateDto);
        return new ResponseEntity<>(modelMapper.map(updatedAccount, AccountDto.Response.class),
                HttpStatus.OK);
    }

    // TODO 예외 처리 네번째 방법 (콜백 비스무리한거...)
    @ExceptionHandler(UserDuplicatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUserDuplicatedException(UserDuplicatedException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("[" + e.getUsername() + "] 중복된 username 입니다.");
        errorResponse.setCode("duplicated.username.exception");
        return errorResponse;
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAccountNotFoundException(AccountNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("[" + e.getId() + "]에 해당하는 계정이 없습니다.");
        errorResponse.setCode("account.not.found.exception");
        return errorResponse;
    }
}
