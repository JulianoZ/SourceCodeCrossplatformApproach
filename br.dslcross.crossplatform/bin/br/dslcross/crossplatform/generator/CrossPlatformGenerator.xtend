/*
 * generated by Xtext 2.13.0
 */
package br.dslcross.crossplatform.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext



import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import br.dslcross.crossplatform.crossPlatform.Deploy
import br.dslcross.crossplatform.crossPlatform.PlatformDecl




/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class CrossPlatformGenerator extends AbstractGenerator {
	
	

	    String LingDaPlataforma = ""
	    String NomePlataformaDeclarada = ""	        
	    @Inject extension IQualifiedNameProvider	   
	    @Inject CrossplatformGeneratorJava generatorJava;
	    @Inject CrossplatformGeneratorCSharp generatorCSharp;
	    @Inject CrossplatformGeneratorSwift generatorSwift;	   
	
	    
	
	

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		fsa.generateFile('greetings.txt', 'People to greet: ' + 
//			resource.allContents
//				.filter(Greeting)
//				.map[name]
//				.join(', '))



		            for (e : resource.allContents.toIterable.filter(Deploy)) {


                        for(pl : e.entityToDeploy){              	  
             	             println("Nome Entidade: "+ pl.ent.name + " Tipo da entidade (plataforma):  " + pl.plat.fullyQualifiedName.toString) //Esta pegando corretamente os tipos de plataformas e nomes
             	             
             	             //Verificar qual a linguagem usada na plataforma declarada             	             
             	             for (pe : resource.allContents.toIterable.filter(PlatformDecl)) {
             	             	if(pe.name.toString == pl.plat.fullyQualifiedName.toString){ //Verifica qual a linguagem declarada para cada plataforma
             	             		LingDaPlataforma = pe.base.toString
             	             		NomePlataformaDeclarada = pl.plat.fullyQualifiedName.toString
             	             	}
             	             	
             	             }     	             
  
             		         switch LingDaPlataforma{ //Recupera o tipo de cada entity e redireciona para o seu respectivo gerador
             		     	    case "Swift":   generatorSwift.GenerateData(resource, fsa, context, pl.ent.name, NomePlataformaDeclarada)  //Passando a classe que deve ser gerada na plataforma iOS
             		     	    case "Java":    generatorJava.GenerateData(resource, fsa, context, pl.ent.name, NomePlataformaDeclarada)  //Passando a classe que deve ser gerada na plataforma iOS
             		     	    case "CSharp":  generatorCSharp.GenerateData(resource, fsa, context, pl.ent.name, NomePlataformaDeclarada)        		     	
             		     	    //default : generatorGeneral.GenerateData(input, fsa, context, pl.name)  //Passando a classe que deve ser gerada na plataforma iOS
             		          }
         			
       		     }//for Deploy             	     
             	}//override doGenerate	




	}
}

