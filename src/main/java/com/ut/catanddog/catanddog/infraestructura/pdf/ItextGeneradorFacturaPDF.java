package com.ut.catanddog.catanddog.infraestructura.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ut.catanddog.catanddog.dominio.modelo.Factura;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ItextGeneradorFacturaPDF {

    private static final Font TITLE_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font SUBTITLE_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private static final Font MESSAGE_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);

    public void generar(Factura factura, String rutaSalida) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
            document.open();
            agregarLogo(document);
            agregarTitulo(document);
            agregarMensajeLegal(document);
            agregarDirecciones(document);
            agregarTablaFactura(document, factura);
            agregarCodigoBarras(document, writer, String.valueOf(factura.getId()));
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Error al generar PDF de factura", e);
        } finally {
            document.close();
        }
    }

    private void agregarLogo(Document document) throws DocumentException {
        try {
            Image logo = Image.getInstance(getClass().getResource("/imagenes/CatandDog.jpeg"));
            logo.scaleToFit(100, 100);
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception e) {
            // Logo es opcional, continuar sin él
        }
    }

    private void agregarTitulo(Document document) throws DocumentException {
        Paragraph title = new Paragraph("Factura Electrónica", TITLE_FONT);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));
    }

    private void agregarMensajeLegal(Document document) throws DocumentException {
        Paragraph message = new Paragraph(
                "Factura impresa por Computadora resolución Dian No 18764052371431 de 2023-07-26 Vigencia 12 MESES",
                MESSAGE_FONT);
        message.setAlignment(Element.ALIGN_CENTER);
        document.add(message);
        document.add(new Paragraph(" "));
    }

    private void agregarDirecciones(Document document) throws DocumentException {
        Paragraph dir1 = new Paragraph("Sede Principal Cádiz Carrera 4B #31-14 Pbx. 2645486", SUBTITLE_FONT);
        dir1.setAlignment(Element.ALIGN_CENTER);
        document.add(dir1);

        Paragraph dir2 = new Paragraph("Sede Vergel Centro Comercial Vergel Local 112", SUBTITLE_FONT);
        dir2.setAlignment(Element.ALIGN_CENTER);
        document.add(dir2);

        document.add(new Paragraph(" "));
    }

    private void agregarTablaFactura(Document document, Factura factura) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(factura.getFechaVenta());

        table.addCell("Factura No:");
        table.addCell(String.valueOf(factura.getId()));
        table.addCell("Estado:");
        table.addCell(factura.getEstado());
        table.addCell("Fecha:");
        table.addCell(fecha);
        table.addCell("IVA:");
        table.addCell(String.valueOf(factura.getIva()));
        table.addCell("Subtotal:");
        table.addCell(String.valueOf(factura.getSubtotal()));
        table.addCell("Total a pagar:");
        table.addCell(String.valueOf(factura.getTotalPagar()));

        if (factura.getDueño() != null) {
            table.addCell("Nombre del dueño:");
            table.addCell(factura.getDueño().getNombre());
        }

        if (factura.getServicios() != null && !factura.getServicios().isEmpty()) {
            var servicio = factura.getServicios().get(0);
            table.addCell("Cantidad:");
            table.addCell(String.valueOf(servicio.getCantidad()));
            table.addCell("Nombre del servicio:");
            table.addCell(servicio.getNombre());
            table.addCell("Precio unitario:");
            table.addCell(String.valueOf(servicio.getPrecio()));
            table.addCell("Porcentaje de IVA:");
            table.addCell(String.valueOf(servicio.getPorcentajeIva()));
        }

        document.add(table);
        document.add(new Paragraph(" "));
    }

    private void agregarCodigoBarras(Document document, PdfWriter writer, String codigo) throws DocumentException {
        Barcode128 barcode = new Barcode128();
        barcode.setCode(codigo);
        Image code128Image = barcode.createImageWithBarcode(writer.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
        code128Image.setAlignment(Element.ALIGN_CENTER);
        document.add(code128Image);
    }
}
