package dev.aziz.amazonrestapi.services;

import dev.aziz.amazonrestapi.dtos.SignUpDto;
import dev.aziz.amazonrestapi.dtos.UserDto;
import dev.aziz.amazonrestapi.dtos.UserSummaryDto;
import dev.aziz.amazonrestapi.entities.User;
import dev.aziz.amazonrestapi.exceptions.AppException;
import dev.aziz.amazonrestapi.mappers.UserMapper;
import dev.aziz.amazonrestapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserSummaryDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserSummaryDtos(users);
    }

    public UserSummaryDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found.", HttpStatus.NOT_FOUND));
        UserSummaryDto userSummaryDto = userMapper.userToUserSummaryDto(user);
        return userSummaryDto;
    }

    public UserSummaryDto deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found.", HttpStatus.NOT_FOUND));
        userRepository.deleteById(id);
        return userMapper.userToUserSummaryDto(user);
    }

    public UserSummaryDto createUser(SignUpDto signUpDto) {
        User user = userMapper.signUpToUser(signUpDto);
        user.setPassword(new String(signUpDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.userToUserSummaryDto(savedUser);
    }

    public UserSummaryDto editUserById(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found.", HttpStatus.NOT_FOUND));
        System.out.println("UserDto: " + userDto.toString());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setBirthDate(userDto.getBirthDate());
        User updatedUser = userRepository.save(user);
        System.out.println("UpdatedUser: " + updatedUser.toString());
        return userMapper.userToUserSummaryDto(updatedUser);
    }
}
