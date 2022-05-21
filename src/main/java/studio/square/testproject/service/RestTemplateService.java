package studio.square.testproject.service;

import org.springframework.http.ResponseEntity;
import studio.square.testproject.data.dto.MemberDTO;

public interface RestTemplateService {

    String getAroundHub();

    String getName();

    String getName2();

    ResponseEntity<MemberDTO> postDto();

    ResponseEntity<MemberDTO> addHeader();
}
