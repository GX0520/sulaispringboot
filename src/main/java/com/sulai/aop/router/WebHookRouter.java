package com.sulai.aop.router;

import com.sulai.aop.annotation.PushTask;
import com.sulai.aop.dict.DictVO;
import com.sulai.aop.dict.Education;
import com.sulai.aop.model.TaskModel;
import com.sulai.aop.service.impl.ChatBaseServiceImpl;
import com.sulai.aop.supports.SendRequestProcessor;
import com.sulai.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:sulai
 * @Date:2020/10/25 15:13
 * @Description:
 * @Version:1.0.0
 */
@RestController
public class WebHookRouter {

    @Autowired
    private ChatBaseServiceImpl chatBaseService;

    @RequestMapping("/webHook")
    public CommonResult sendMessage(@RequestBody TaskModel taskModel) {
        chatBaseService.doHandMessage(taskModel);
        return CommonResult.success();
    }

    @RequestMapping("/pushTask")
    public CommonResult doPushTask() {
        chatBaseService.testPushTashAnnotation();
        return CommonResult.success();
    }

    @GetMapping("/mapping/dict")
    public CommonResult mappingDict() {

        Education education = new Education();
        education.setEducationId(1);

        DictVO dictVO = DictVO.builder()
                .channelId(1)
                .education(education)
                .id(23).build();


        return CommonResult.success(dictVO);
    }
}
