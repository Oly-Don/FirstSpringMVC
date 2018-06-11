package com.oly.dev;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * usege:
 * Created by oly on 2018/6/1.
 */
@Service
public interface IRequestInvoker {

    public RequestRunner get(RequestPojo pojo);

    public RequestRunner post(RequestPojo pojo);

}
