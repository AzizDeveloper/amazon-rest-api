package dev.aziz.amazonrestapi.mappers;

import dev.aziz.amazonrestapi.dtos.SignUpDto;
import dev.aziz.amazonrestapi.dtos.UserDto;
import dev.aziz.amazonrestapi.dtos.UserSummaryDto;
import dev.aziz.amazonrestapi.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

    List<UserDto> usersToUserDtos(List<User> users);

    List<UserSummaryDto> usersToUserSummaryDtos(List<User> users);

    UserSummaryDto userToUserSummaryDto(User user);
}
