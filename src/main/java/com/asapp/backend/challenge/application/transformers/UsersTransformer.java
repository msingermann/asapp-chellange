package com.asapp.backend.challenge.application.transformers;

import com.asapp.backend.challenge.application.model.data.User;
import com.asapp.backend.challenge.application.model.responses.CreateUserResponse;

public class UsersTransformer {

    /**
     * Transforms a {@link User} into a {@link CreateUserResponse}.
     *
     * @param user User to transform to CreateUserResponse.
     * @return {@link CreateUserResponse}.
     */
    public static CreateUserResponse transform(User user) {
        return new CreateUserResponse(user.getId());
    }

}
