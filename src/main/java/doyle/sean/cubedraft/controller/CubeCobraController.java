package doyle.sean.cubedraft.controller;

import doyle.sean.cubedraft.service.CubeCobraService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CubeCobraController {

    private final CubeCobraService cubeCobraService;

    public CubeCobraController(CubeCobraService cubeCobraService) {
        this.cubeCobraService = cubeCobraService;
    }

    @GetMapping("/cube/{id}")
    public List<String> getCubeList(@PathVariable String id){
        return cubeCobraService.getCube(id);
    }

}
