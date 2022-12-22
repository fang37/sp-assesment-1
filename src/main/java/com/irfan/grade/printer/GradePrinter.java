package com.irfan.grade.printer;

import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public interface GradePrinter {

    public void print() throws IOException;

}
