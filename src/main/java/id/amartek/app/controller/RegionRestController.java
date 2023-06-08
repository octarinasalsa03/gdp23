package id.amartek.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.handler.Response;
import id.amartek.app.model.Region;
import id.amartek.app.service.RegionService;

@RestController
@RequestMapping("api")
public class RegionRestController {
    @Autowired
    private RegionService<Region> regionService;

    @GetMapping("region")
    public ResponseEntity<Object> Get() {
        return Response.generate("data ditemukan", HttpStatus.OK, regionService.Get());
    }

    @GetMapping("region/{id}")
    public ResponseEntity<Object> Get(Integer id) {
        Optional<Region> region = regionService.Get(id);
        if (region.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, region);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

    @PostMapping("region")
    public ResponseEntity<Object> Save(Region region) {
        Boolean result = regionService.Save(region);
        if (result) {
            return Response.generate("data berhasil dimasukkan", HttpStatus.OK);
        }
        return Response.generate("data gagal dimasukkan", HttpStatus.OK);
    }

    @PostMapping("region/{id}")
    public ResponseEntity<Object> Delete(Integer id) {
        Boolean result = regionService.Delete(id);
        if (result) {
            return Response.generate("data berhasil dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }

}
