package com.example.pdfgenerator;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PdfGeneratorApplication {

    public static void main(String[] args) throws IOException {

        String filePath = PdfGeneratorApplication.class.getClassLoader().getResource("test.html").getFile();

        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));

        OutputStream outputStream = new FileOutputStream("message.pdf");
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(fileContent);
//        renderer.setDocument(filePath); // for path
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }
}
