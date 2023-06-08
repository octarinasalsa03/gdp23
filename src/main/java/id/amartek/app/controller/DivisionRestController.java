package id.amartek.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.handler.Response;
import id.amartek.app.model.Division;
import id.amartek.app.service.DivisionService;

@RestController
@RequestMapping("api")
public class DivisionRestController {
    @Autowired
    private DivisionService<Division> divisionService;

    @GetMapping("division")
    public ResponseEntity<Object> Get() {
        return Response.generate("data ditemukan", HttpStatus.OK, divisionService.Get());
    }

    @GetMapping("division/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) Integer id) {
        Optional<Division> division = divisionService.Get(id);
        if (division.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, division);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

    @PostMapping("division")
    public ResponseEntity<Object> Save(Division division) {
        Boolean result = divisionService.Save(division);
        if (result) {
            return Response.generate("data berhasil dimasukkan", HttpStatus.OK);
        }
        return Response.generate("data gagal dimasukkan", HttpStatus.OK);
    }

    @DeleteMapping("division/{id}")
    public ResponseEntity<Object> Delete(Integer id) {
        Boolean result = divisionService.Delete(id);
        if (result) {
            return Response.generate("data berhasil dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }

}
