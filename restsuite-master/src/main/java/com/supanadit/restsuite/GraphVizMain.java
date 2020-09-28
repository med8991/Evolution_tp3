package com.supanadit.restsuite;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.node;
import static guru.nidi.graphviz.model.Factory.to;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizJdkEngine;
import guru.nidi.graphviz.model.LinkSource;
import guru.nidi.graphviz.model.MutableGraph;

public class GraphVizMain {

	public static void main(String[] args) {
		System.out.println("Generation du graphe , Attendezzz .....");
		generateGraph("log", "graph", "graph.png");
		System.out.println("C'est bon , vous pouvez raffrachir votre projet");
	}

	public static void generateGraph(String filename,String nameGraphe ,String output) {
		 List<String> records = new ArrayList<String>();
		 
		 try
		  {
				BufferedReader mylog = Files.newBufferedReader(Paths.get(filename));
				String line = "";
				List<LinkSource> linkSource = new ArrayList<LinkSource>();
				List<String> arrayNode = new ArrayList<String>();
		    while ((line = mylog.readLine()) != null) {
		    	arrayNode.add(line);
		    }
		    for(int i = 0 ; i < arrayNode.size() -1 ; i++) {
		    	String classes[] = arrayNode.get(i).split("->");
		    	linkSource.add(node(classes[0]).link(to(node(classes[1]))));
		    	i++;
		    }
		    
			MutableGraph graph = mutGraph(nameGraphe).setDirected(true).add(linkSource);
			Graphviz.fromGraph(graph).width(8000).height(4000).render(Format.PNG).toFile(new File(output));
		    
		  }catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read file");
		    e.printStackTrace();
		   
		  }
		
		 
		 
	}
	
	
}