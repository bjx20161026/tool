package com.fengyuan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data @AllArgsConstructor class User {
    public User(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
	}
	private String name;
    private int age;
    private String tel;
}
