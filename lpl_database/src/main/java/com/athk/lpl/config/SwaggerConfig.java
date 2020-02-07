package com.athk.lpl.config;

import com.athk.lpl.controller.Team.TeamController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket Teamdocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfoteam())
                .groupName("Team")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.Team"))
                .build();
    }
    private ApiInfo apiInfoteam(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("参赛队伍",
                "零星意胸中翻涌不肯休",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }


    @Bean
    public Docket Playerdocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfoplayer())
                .groupName("Player")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.Player"))
                .build();
    }
    private ApiInfo apiInfoplayer(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("参赛选手",
                "玲珑四壁争将本色漆",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    @Bean
    public Docket matchdocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfomatch())
                .groupName("Match").select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.Match"))
                .build();
    }
    private ApiInfo apiInfomatch(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("比赛记录",
                "遑遑无归闲云逸鹤",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    @Bean
    public Docket coachdocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfocoach())
                .groupName("Coach").select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.Coach"))
                .build();
    }
    private ApiInfo apiInfocoach(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("参赛教练",
                "不着痕迹默默氲透卷轴",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    @Bean
    public Docket Changedocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfoChange())
                .groupName("Club_Change").select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.ClubChange"))
                .build();
    }
    private ApiInfo apiInfoChange(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("转会消息",
                "恰无心翻乱曲三百首",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    @Bean
    public Docket worldgamedocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfoworldgame())
                .groupName("World Game").select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.WorldGame"))
                .build();
    }
    private ApiInfo apiInfoworldgame(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("世界赛消息",
                "当时爱强赋愁而今怕听更漏",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

    @Bean
    public Docket WorldListdocket(){
        return new Docket(SWAGGER_2)
                .apiInfo(apiInfoWorldList())
                .groupName("World List").select()
                .apis(RequestHandlerSelectors.basePackage("com.athk.lpl.controller.WorldList"))
                .build();
    }
    private ApiInfo apiInfoWorldList(){

        Contact contact = new Contact("郝凯&王冲冲", "", "2398894692@qq.com");

        return new ApiInfo("参赛列表",
                "几日前东风吹我好花欲燃手",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

}
