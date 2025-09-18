interface Document
{
    void open();
    void save();
}
class PDFDocument implements Document
{
    @Override
    public void open()
    {
        System.out.println("Codigo para abrir PDF");
    }

    @Override
    public void save()
    {
        System.out.println("Codigo para Guardar PDF;");
    }
}
class DocxDocument implements Document
{
    @Override
    public void open()
    {
        System.out.println("Codigo para abrir DOCX");
    }

    @Override
    public void save()
    {
        System.out.println("Codigo para guardar DOCX");
    }
}
class DocumentFactory
{
    public static Document createDocument (String extension)
    {
        if(extension.equals("pdf"))
        {
            return new PDFDocument();
        }
        else if(extension.equals("docx"))
        {
            return new DocxDocument();
        }
        throw new UnsupportedOperationException("Formato no soportado");
    }
}
public class Documentos
{
    public static void main(String[] args)
    {
        DocumentFactory factory = new DocumentFactory();
        Document docx = factory.createDocument("docx");
        docx.open();
        docx.save();
        Document pdf = factory.createDocument("pdf");
        pdf.open();
        pdf.save();
    }
}