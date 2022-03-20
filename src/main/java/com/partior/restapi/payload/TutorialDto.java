package com.partior.restapi.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class TutorialDto {

    private long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private boolean published;


}
