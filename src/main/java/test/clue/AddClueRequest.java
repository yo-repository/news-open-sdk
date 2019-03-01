package test.clue;

import com.yo.news.open.sdk.OpenRequest;
import com.yo.news.open.sdk.example.TestResponseModel;
import com.yo.news.open.sdk.http.MethodType;

/**
 * @author:JAN
 * @date:9:22 2019-3-1
 * @note:
 **/
public class AddClueRequest extends OpenRequest<TestResponseModel> {

    public AddClueRequest(String requestUri, MethodType methodType) {
        super(requestUri, methodType);
    }

    @Override
    public Class<TestResponseModel> getResponseModelClass() {
        return null;
    }
}
