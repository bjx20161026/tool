package com.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.esbUpload.EsbUpload;

@Controller
@RequestMapping("/EsbUpload")
public class EsbUploadController {
@Autowired
EsbUpload esbUpload;
}
