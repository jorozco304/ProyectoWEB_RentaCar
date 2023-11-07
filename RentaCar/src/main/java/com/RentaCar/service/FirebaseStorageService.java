package com.RentaCar.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {


    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

        final String BucketName = "proyectorentacar-b230d.appspot.com";
        final String rutaSuperiorStorage = "RentaCar";
        final String rutaJsonFile = "firebase";
        final String archivoJsonFile = "proyectorentacar-b230d-firebase-adminsdk-t84ai-7ea11dcdd3.json";
}

