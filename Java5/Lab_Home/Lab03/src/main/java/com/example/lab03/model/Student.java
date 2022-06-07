package com.example.lab03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotEmpty
    private String id;
    @NotEmpty(message = "Không được để trống")
    @Min(4)
    private String name;
    @Email
    @NotEmpty
    private String email;
    private String faculty;
    @Min(0)
    @Max(10)
    private Double mark;
    private Boolean gender;
    private List<String> hobbies;
    private MultipartFile imageFile;
    private String imageUrl;

}

