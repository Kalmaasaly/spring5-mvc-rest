package guru.springframework.spring5mvcrest.services;

import guru.springframework.spring5mvcrest.api.v1.mapper.VendorMapper;
import guru.springframework.spring5mvcrest.api.v1.model.VendorDTO;
import guru.springframework.spring5mvcrest.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }


    @Override
    public List<VendorDTO> getAllVendors() {
        return null;
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO VendorDTO) {
        return null;
    }

    @Override
    public VendorDTO saveVendorDto(Long id, VendorDTO VendorDTO) {
        return null;
    }

    @Override
    public VendorDTO patchVendorDto(Long id, VendorDTO VendorDTO) {
        return null;
    }

    @Override
    public void deleteVendorById(Long id) {

    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return null;
    }
}
