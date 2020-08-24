package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAllVendors();
    VendorDTO createNewVendor(VendorDTO VendorDTO);
    VendorDTO saveVendorDto(Long id,VendorDTO VendorDTO);
    VendorDTO patchVendorDto(Long id,VendorDTO VendorDTO);
    void deleteVendorById(Long id);
    VendorDTO getVendorById(Long id);
}
