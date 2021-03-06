package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.customizacao.service.ContaService;
import io.swagger.customizacao.util.RespostasUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-19T14:21:55.755Z")

@Controller
public class ContaApiController implements ContaApi {

    @Autowired
    private ContaService contaService;

    @Autowired
    private RespostasUtil respostasUtil;

    public ResponseEntity<Double> consultaSaldo(
            @ApiParam(value = "",required=true)
            @PathVariable("agencia")
                    Integer agencia,

            @ApiParam(value = "",required=true)
            @PathVariable("numero")
                    Long numero,

            @ApiParam(value = "",required=true)
            @PathVariable("digito")
                    Integer digito,

            @ApiParam(value = "" ,required=true)
            @RequestHeader(value="Authorization", required=true)
                    String authorization) {

        try {
            System.out.println(authorization);
            return contaService.consultaSaldo(authorization, agencia, numero, digito);
        }catch (Exception e){
            return respostasUtil.getErroInternoDouble(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_SALDO);
        }

    }

}
