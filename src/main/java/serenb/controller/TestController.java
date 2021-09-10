package serenb.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import serenb.dto.response.FormResponseDto;
import serenb.dto.response.UserResponseDto;

@Controller
public class TestController {
    @GetMapping
    public String startPage() {
        return "index";
    }

    @GetMapping("/no-json")
    @ResponseBody
    public String testWithoutJSON(@RequestParam String name,
                                  @RequestParam int age) {
        return String.format("My name is %s, \nI am %2d.", name, age);
    }

    @GetMapping("/json")
    @ResponseBody
    public UserResponseDto testWithJSON(@RequestParam String name, @RequestParam int age) {
        return new UserResponseDto(name, age);
    }

    @GetMapping("json-array")
    @ResponseBody
    public UserResponseDto[] testWithJSONArray() {
        return new UserResponseDto[]{
                new UserResponseDto("Benito", 19),
                new UserResponseDto("Bob", 22)
        };
    }

    @GetMapping("/jsp")
    public String testJSP(Model model) {
        List<UserResponseDto> list = new ArrayList<>();
        list.add(new UserResponseDto("Denis", 22));
        list.add(new UserResponseDto("Jackson", 28));
        model.addAttribute("users", list);
        return "test";
    }

    @PostMapping
    @ResponseBody
    public FormResponseDto getFormResponse(HttpServletRequest req) {
        FormResponseDto formResponseDto = new FormResponseDto();
        formResponseDto.setName(req.getParameter("name"));
        formResponseDto.setAge(Integer.parseInt(req.getParameter("age")));
        formResponseDto.setMood(req.getParameter("mood"));
        return formResponseDto;
    }

    @GetMapping("/to-json")
    @ResponseBody
    public UserResponseDto setDataToDb() {
        String stringUrl = "https://spring-testing26.herokuapp.com/json?name=Benito&age=19";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(stringUrl)).build();
        String stringLikeJSON = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
        JSONObject object = new JSONObject(stringLikeJSON);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(object.getString("name"));
        userResponseDto.setAge(object.getInt("age"));
        return userResponseDto;
    }
}
