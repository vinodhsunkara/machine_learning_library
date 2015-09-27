package com.ml.unsupervised.tests;

import java.io.File;

import com.ml.unsupervised.loaders.CSVFileReader;

import dist.Distribution;
import dist.MultivariateGaussian;
import func.EMClusterer;
import func.KMeansClusterer;
import shared.DataSet;
import shared.Instance;
import shared.filt.IndependentComponentAnalysis;
import shared.reader.CSVDataSetReader;
import shared.reader.DataSetReader;
import util.linalg.DenseVector;
import util.linalg.RectangularMatrix;

/**
 * Testing EM on ICA
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class EM_ICATest {
    /**
     * The test main
     * @param args ignored
     */
    public static void main(String[] args) throws Exception {
       // Instance[] instances = new Instance[100];
        
        CSVFileReader dsr = new CSVFileReader();
        boolean skipHeader = true;
        DataSet set = dsr.read(new File("").getAbsolutePath() + "/resources/marketing_survey.csv", skipHeader);
        
        System.out.println("Before ICA");
        System.out.println(set.getDescription());
        
        //System.out.println(set);
        IndependentComponentAnalysis filter = new IndependentComponentAnalysis(set);
        filter.filter(set);
        System.out.println("After ICA");
        System.out.println(set.getDescription());
        
        EMClusterer em = new EMClusterer();
        em.estimate(set);
        System.out.println("After EM");
        System.out.println(set.getDescription());
        System.out.println(em);
    }
}
