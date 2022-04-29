package com.asapp.backend.challenge.application.transformers;

import com.asapp.backend.challenge.application.model.responses.CreateUserResponse;
import com.asapp.backend.challenge.application.model.data.User;

public class UsersTransformer {

    public static CreateUserResponse transform(User user) {
        return new CreateUserResponse(user.getId());
    }

}
