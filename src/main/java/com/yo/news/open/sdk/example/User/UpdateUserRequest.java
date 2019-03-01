package com.yo.news.open.sdk.example.User;

import com.yo.news.open.sdk.example.TestResponseModel;
import com.yo.news.open.sdk.OpenRequest;
import com.yo.news.open.sdk.http.MethodType;

/**
 * Author:JAN
 * Date:16:09 2018-8-22
 * Note:
 **/
public class UpdateUserRequest extends OpenRequest<TestResponseModel> {
    public UpdateUserRequest() {
        super("/open/tob/user/v1/update.json", MethodType.POST);
    }

    public Class getResponseModelClass() {
        return TestResponseModel.class;
    }
}
