package net.datasa.exam1.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.datasa.exam1.dto.UserDTO;
import net.datasa.exam1.entity.UserEntity;
import net.datasa.exam1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Service
public class UserService {

    @Autowired
    UserRepository repository;

    /**
     * 회원가입 처리 (id, pwd, name, phone 받아서 엔티티에 넣기)
     * @param dto
     */
    public void signUp(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setPwd(dto.getPwd());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());

        repository.save(entity);
    }

    /**
     * 모든 회원정보(dto)를 목록(dtoList)으로 출력
     * @return
     */
    public List<UserDTO> showAll() {
        List<UserEntity> entityList = repository.findAll();
        UserDTO dto = null;
        ArrayList<UserDTO> dtoList = new ArrayList<>();

        for (UserEntity entity : entityList) {
            dto = new UserDTO();
            dto.setId(entity.getId());
            dto.setPwd(entity.getPwd());
            dto.setName(entity.getName());
            dto.setPhone(entity.getPhone());

            dtoList.add(dto);
        } // for

        return dtoList;
    }
}
