package service;

public class FileResources {

    private String filePathToXml;
    private String PathToXslt;

    public String getFilePath() {
        return filePathToXml;
    }

    public void setFilePath(String filePath) {
        this.filePathToXml = filePath;
    }

    public void setPathToXslt(String pathToXslt) {
        PathToXslt = pathToXslt;
    }

    public String getPathToXslt() {
        return PathToXslt;
    }
}