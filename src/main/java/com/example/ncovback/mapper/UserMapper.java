package com.example.ncovback.mapper;

import com.example.ncovback.entity.Town;
import com.example.ncovback.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(User user);

    Integer register(User user) throws Exception;

    Integer ifExist(User user);

    Integer changePassword(User user);

    List<User> getRelativebyid(User user);

    Integer addRelativebyid(User user);

    Integer addRelation(Integer user_id,Integer relative_id);

    Integer uploadPicture(User user);

    Integer changeUserPhone(User user);

    Integer deleteRelation(Integer user_id, Integer relative_id);

    Integer deleteRelAccount(Integer relative_id);

    Integer declareHealthCode(User user);

    String getTownid(User user);

    List<Town> getTownbyarea(String area_name);

    Integer setYellowCode(Integer user_id);

    Integer setRedCode(Integer user_id);

    Integer setGreenCode(Integer user_id);

    User getselfHealthCode(Integer user_id);
}
