package br.dslcross.crossplatform.generator;

import br.dslcross.crossplatform.crossPlatform.AbrevCmd;
import br.dslcross.crossplatform.crossPlatform.AssignmentCmdFor;
import br.dslcross.crossplatform.crossPlatform.AttribID;
import br.dslcross.crossplatform.crossPlatform.Attribute;
import br.dslcross.crossplatform.crossPlatform.CallAttributeObject;
import br.dslcross.crossplatform.crossPlatform.CommandFeature;
import br.dslcross.crossplatform.crossPlatform.CommandOperation;
import br.dslcross.crossplatform.crossPlatform.CommandPlat;
import br.dslcross.crossplatform.crossPlatform.DSLConcreteTypeRef;
import br.dslcross.crossplatform.crossPlatform.DSLGenericTypeRef;
import br.dslcross.crossplatform.crossPlatform.DSLTypeRef;
import br.dslcross.crossplatform.crossPlatform.DataType;
import br.dslcross.crossplatform.crossPlatform.Deploy;
import br.dslcross.crossplatform.crossPlatform.Entity;
import br.dslcross.crossplatform.crossPlatform.EntityGlobCall;
import br.dslcross.crossplatform.crossPlatform.EntityGlobal;
import br.dslcross.crossplatform.crossPlatform.ExprArit;
import br.dslcross.crossplatform.crossPlatform.ExprLogica;
import br.dslcross.crossplatform.crossPlatform.Fator;
import br.dslcross.crossplatform.crossPlatform.FatorLogico;
import br.dslcross.crossplatform.crossPlatform.MethodCallCmd;
import br.dslcross.crossplatform.crossPlatform.MethodCallGlob;
import br.dslcross.crossplatform.crossPlatform.MethodCallGlobal;
import br.dslcross.crossplatform.crossPlatform.MethodCallOp;
import br.dslcross.crossplatform.crossPlatform.OpElse;
import br.dslcross.crossplatform.crossPlatform.OpElseIf;
import br.dslcross.crossplatform.crossPlatform.OpLogicoDoWhile;
import br.dslcross.crossplatform.crossPlatform.OpLogicoFor;
import br.dslcross.crossplatform.crossPlatform.OpLogicoIF;
import br.dslcross.crossplatform.crossPlatform.OpLogicoWhile;
import br.dslcross.crossplatform.crossPlatform.Operation;
import br.dslcross.crossplatform.crossPlatform.OperationGlobCall;
import br.dslcross.crossplatform.crossPlatform.OperationGlobCallOld;
import br.dslcross.crossplatform.crossPlatform.OperationGlobal;
import br.dslcross.crossplatform.crossPlatform.Parameter;
import br.dslcross.crossplatform.crossPlatform.Platform;
import br.dslcross.crossplatform.crossPlatform.PlatformDecl;
import br.dslcross.crossplatform.crossPlatform.SpecialCommand;
import br.dslcross.crossplatform.crossPlatform.StringTemplateFreeCod;
import br.dslcross.crossplatform.crossPlatform.Termo;
import br.dslcross.crossplatform.crossPlatform.TermoLogico;
import br.dslcross.crossplatform.crossPlatform.Type;
import br.dslcross.crossplatform.crossPlatform.Vector;
import br.dslcross.crossplatform.generator.VelocityGenerator;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CrossplatformGeneratorJava extends AbstractGenerator {
  private final ArrayList<String> platSeparatedController = CollectionLiterals.<String>newArrayList("Android", "iOS");
  
  private final String varController = "Controller";
  
  private String EntityPlatform = "";
  
  private String LingDaPlataforma = "";
  
  private String PlataformaDaEntidade = "";
  
  private String NomePlataformaDeclarada = "";
  
  private final ArrayList<String> listPlatform = new ArrayList<String>();
  
  private final ArrayList<String> listFeat = new ArrayList<String>();
  
  private final ArrayList<String> OpSignPlatlistNome = new ArrayList<String>();
  
  private String[][] OpSignPlatArray2D = CrossplatformGeneratorJava.new2DString2ArrayOfSize(20, 20);
  
  private Resource res;
  
  private String platAtual = "";
  
  @Pure
  public static String[][] new2DString2ArrayOfSize(final int nrow, final int ncol) {
    final Function1<Object, String[]> _function = (Object it) -> {
      return new String[ncol];
    };
    return ((String[][])Conversions.unwrapArray(ListExtensions.<Object, String[]>map(((List<Object>)Conversions.doWrapArray(new Object[nrow])), _function), String[].class));
  }
  
  private String[][] classOpSignParamArray2D = CrossplatformGeneratorJava.new2DString2ArrayOfSize(20, 20);
  
  private final ArrayList<String> classNomeOperation = new ArrayList<String>();
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  public void GenerateData(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context, final String EntityPlatform, final String NomePlatDeclarada) {
    this.EntityPlatform = EntityPlatform;
    this.NomePlataformaDeclarada = NomePlatDeclarada;
    this.res = resource;
    this.platAtual = NomePlatDeclarada;
    this.doGenerate(resource, fsa, context);
    InputOutput.<String>println(("GeneratorJava - m�todo GenerateData - Nome da entity :" + EntityPlatform));
  }
  
  public CharSequence compileEntityCmd(final CommandFeature cmd, final Entity e, final Resource resource, final ArrayList<String> listPlat, final ArrayList<String> listFeatures, final ArrayList<String> classNomeOperation, final String[][] classOpSignParamArray2D, final String[][] OpSignPlatArray2D, final ArrayList<String> OpSignPlatlistNome, final Boolean PlatEntity, final String PlataformaDaEntidade, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    CharSequence _xifexpression = null;
    if ((cmd instanceof Attribute)) {
      _xifexpression = this.compile(((Attribute)cmd));
    } else {
      CharSequence _xifexpression_1 = null;
      if ((cmd instanceof Operation)) {
        CharSequence _xifexpression_2 = null;
        boolean _equals = PlatEntity.equals(Boolean.valueOf(false));
        if (_equals) {
          _xifexpression_2 = this.compileOperation(((Operation)cmd), classNomeOperation, classOpSignParamArray2D);
        } else {
          CharSequence _xifexpression_3 = null;
          boolean _equals_1 = PlatEntity.equals(Boolean.valueOf(true));
          if (_equals_1) {
            _xifexpression_3 = this.compileOperation(((Operation)cmd), OpSignPlatlistNome, OpSignPlatArray2D);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        CharSequence _xifexpression_4 = null;
        if ((cmd instanceof OperationGlobCallOld)) {
          _xifexpression_4 = this.compileOperationGlob(((OperationGlobCallOld)cmd), PlataformaDaEntidade, resource);
        } else {
          CharSequence _xifexpression_5 = null;
          if ((cmd instanceof EntityGlobCall)) {
            _xifexpression_5 = this.compileEntityGlob(((EntityGlobCall)cmd), PlataformaDaEntidade, resource);
          } else {
            CharSequence _xifexpression_6 = null;
            if ((cmd instanceof OperationGlobCall)) {
              _xifexpression_6 = this.compileControllerGlob(((OperationGlobCall)cmd), PlataformaDaEntidade, resource, fsa, context);
            } else {
              CharSequence _xifexpression_7 = null;
              if ((cmd instanceof StringTemplateFreeCod)) {
                _xifexpression_7 = this.compileStringTemplateFreeCod(((StringTemplateFreeCod)cmd));
              } else {
                CharSequence _xifexpression_8 = null;
                if ((cmd instanceof CallAttributeObject)) {
                  _xifexpression_8 = this.compileCallAttributeObject(((CallAttributeObject)cmd));
                }
                _xifexpression_7 = _xifexpression_8;
              }
              _xifexpression_6 = _xifexpression_7;
            }
            _xifexpression_5 = _xifexpression_6;
          }
          _xifexpression_4 = _xifexpression_5;
        }
        _xifexpression_1 = _xifexpression_4;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence compilePlatCmd(final CommandPlat cmd, final Entity e, final Resource resource, final ArrayList<String> listPlat, final ArrayList<String> listFeatures, final ArrayList<String> classNomeOperation, final String[][] classOpSignParamArray2D, final String[][] OpSignPlatArray2D, final ArrayList<String> OpSignPlatlistNome, final Boolean PlatEntity) {
    CharSequence _xifexpression = null;
    if ((cmd instanceof Attribute)) {
      _xifexpression = this.compile(((Attribute)cmd));
    } else {
      CharSequence _xifexpression_1 = null;
      if ((cmd instanceof Operation)) {
        CharSequence _xifexpression_2 = null;
        boolean _equals = PlatEntity.equals(Boolean.valueOf(false));
        if (_equals) {
          _xifexpression_2 = this.compileOperation(((Operation)cmd), classNomeOperation, classOpSignParamArray2D);
        } else {
          CharSequence _xifexpression_3 = null;
          boolean _equals_1 = PlatEntity.equals(Boolean.valueOf(true));
          if (_equals_1) {
            _xifexpression_3 = this.compileOperation(((Operation)cmd), OpSignPlatlistNome, OpSignPlatArray2D);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String prepareParameters(final Operation cF, final int i, final String varArray) {
    Type _ref = cF.getParams().get(i).getRef();
    boolean _tripleEquals = (_ref == null);
    if (_tripleEquals) {
      String _compileType = this.compileType(cF.getParams().get(i).getType());
      String _plus = (_compileType + varArray);
      String _plus_1 = (_plus + " ");
      String _name = cF.getParams().get(i).getName();
      return (_plus_1 + _name);
    } else {
      Type _ref_1 = cF.getParams().get(i).getRef();
      boolean _tripleNotEquals = (_ref_1 != null);
      if (_tripleNotEquals) {
        String _firstUpper = StringExtensions.toFirstUpper(this.compileType(cF.getParams().get(i).getType()));
        String _plus_2 = (_firstUpper + "<");
        String _treatVariableName = this.treatVariableName(cF.getParams().get(i).getRef().getName().toString());
        String _plus_3 = (_plus_2 + _treatVariableName);
        String _plus_4 = (_plus_3 + ">");
        String _plus_5 = (_plus_4 + varArray);
        String _plus_6 = (_plus_5 + " ");
        String _name_1 = cF.getParams().get(i).getName();
        return (_plus_6 + _name_1);
      } else {
        String _compileType_1 = this.compileType(cF.getParams().get(i).getType());
        String _plus_7 = (_compileType_1 + varArray);
        String _plus_8 = (_plus_7 + " ");
        String _name_2 = cF.getParams().get(i).getName();
        return (_plus_8 + _name_2);
      }
    }
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Entity> _filter = Iterables.<Entity>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Entity.class);
    for (final Entity e : _filter) {
      {
        InputOutput.<String>println("\n\n\n ------------------------------------------------------ \n");
        String _name = e.getName();
        String _plus = ("GeneratorAndroid - m�todo doGenerate - dentro do for - Nome da entidade: " + _name);
        InputOutput.<String>println(_plus);
        this.listFeat.clear();
        int countOp = 0;
        EList<CommandFeature> _features = e.getFeatures();
        for (final CommandFeature featOp : _features) {
          if ((featOp instanceof Operation)) {
            countOp = (countOp + 1);
          }
        }
        this.classOpSignParamArray2D = CrossplatformGeneratorJava.new2DString2ArrayOfSize(countOp, 20);
        this.classNomeOperation.clear();
        int cOpClass = 0;
        EList<CommandFeature> _features_1 = e.getFeatures();
        for (final CommandFeature featVar : _features_1) {
          if ((featVar instanceof Attribute)) {
            CollectionExtensions.<String>addAll(this.listFeat, ((Attribute)featVar).getName());
          } else {
            if ((featVar instanceof Operation)) {
              String varArray = "";
              int _size = ((Operation)featVar).getParams().size();
              ExclusiveRange _greaterThanDoubleDot = new ExclusiveRange(_size, 0, false);
              for (final Integer i : _greaterThanDoubleDot) {
                {
                  String _col1 = ((Operation)featVar).getParams().get((i).intValue()).getCol1();
                  boolean _tripleEquals = (_col1 == null);
                  boolean _not = (!_tripleEquals);
                  if (_not) {
                    varArray = "[]";
                  } else {
                    varArray = "";
                  }
                  (this.classOpSignParamArray2D[cOpClass])[(i).intValue()] = this.prepareParameters(((Operation)featVar), (i).intValue(), varArray.toString());
                }
              }
              CollectionExtensions.<String>addAll(this.classNomeOperation, ((Operation)featVar).getName().toString());
              cOpClass = (cOpClass + 1);
            }
          }
        }
        String _string = e.getName().toString();
        boolean _equals = Objects.equal(this.EntityPlatform, _string);
        if (_equals) {
          Iterable<Deploy> _filter_1 = Iterables.<Deploy>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Deploy.class);
          for (final Deploy dep : _filter_1) {
            EList<Platform> _entityToDeploy = dep.getEntityToDeploy();
            for (final Platform pl : _entityToDeploy) {
              if ((Objects.equal(pl.getEnt().getName().toString(), this.EntityPlatform) && Objects.equal(this.NomePlataformaDeclarada, this._iQualifiedNameProvider.getFullyQualifiedName(pl.getPlat()).toString()))) {
                this.PlataformaDaEntidade = this._iQualifiedNameProvider.getFullyQualifiedName(pl.getPlat()).toString();
                InputOutput.<String>println(("\n Plataforma da entidade: ANDROID >>>>>>>>>>> " + this.PlataformaDaEntidade));
              }
            }
          }
          Iterable<PlatformDecl> _filter_2 = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), PlatformDecl.class);
          for (final PlatformDecl pe : _filter_2) {
            String _string_1 = pe.getName().toString();
            boolean _equals_1 = Objects.equal(_string_1, this.PlataformaDaEntidade);
            if (_equals_1) {
              InputOutput.<String>println(("\n Plataforma atuamente trabalhando >>>>>>>>>>> " + this.PlataformaDaEntidade));
              this.LingDaPlataforma = pe.getBase().toString();
              int countOperationPlat = 0;
              EList<CommandPlat> _cmdList = pe.getCmdList();
              for (final CommandPlat platformOp : _cmdList) {
                if ((platformOp instanceof Operation)) {
                  countOperationPlat++;
                }
              }
              this.OpSignPlatArray2D = CrossplatformGeneratorJava.new2DString2ArrayOfSize(countOperationPlat, 20);
              this.OpSignPlatlistNome.clear();
              int countOpPlat = 0;
              EList<CommandPlat> _cmdList_1 = pe.getCmdList();
              for (final CommandPlat platformOp_1 : _cmdList_1) {
                if ((platformOp_1 instanceof Operation)) {
                  CollectionExtensions.<String>addAll(this.OpSignPlatlistNome, ((Operation)platformOp_1).getName().toString());
                  int _size_1 = ((Operation)platformOp_1).getParams().size();
                  ExclusiveRange _greaterThanDoubleDot_1 = new ExclusiveRange(_size_1, 0, false);
                  for (final Integer i_1 : _greaterThanDoubleDot_1) {
                    String _compileType = this.compileType(((Operation)platformOp_1).getParams().get((i_1).intValue()).getType());
                    String _plus_1 = (_compileType + " ");
                    String _name_1 = ((Operation)platformOp_1).getParams().get((i_1).intValue()).getName();
                    String _plus_2 = (_plus_1 + _name_1);
                    (this.OpSignPlatArray2D[countOpPlat])[(i_1).intValue()] = _plus_2;
                  }
                  countOpPlat = (countOpPlat + 1);
                }
              }
            }
          }
          int verifController = 0;
          int _size_2 = this.platSeparatedController.size();
          String _plus_3 = (" platSeparatedController 1 " + Integer.valueOf(_size_2));
          InputOutput.<String>println(_plus_3);
          int _size_3 = this.platSeparatedController.size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_3, true);
          for (final Integer i_2 : _doubleDotLessThan) {
            {
              String _string_2 = this.platSeparatedController.get((i_2).intValue()).toString();
              String _plus_4 = (((" platSeparatedController 2 " + i_2) + " ") + _string_2);
              InputOutput.<String>println(_plus_4);
              boolean _equals_2 = this.NomePlataformaDeclarada.equals(this.platSeparatedController.get((i_2).intValue()).toString());
              if (_equals_2) {
                boolean _equals_3 = this.EntityPlatform.equals(this.varController);
                if (_equals_3) {
                  verifController = 1;
                }
              }
            }
          }
          boolean _equals_2 = Integer.valueOf(verifController).equals(Integer.valueOf(0));
          if (_equals_2) {
            String _string_2 = this._iQualifiedNameProvider.getFullyQualifiedName(e).toString("/");
            String _plus_4 = (_string_2 + ".java");
            fsa.generateFile(_plus_4, 
              this.compileEntity(e, resource, this.listPlatform, this.listFeat, this.classNomeOperation, this.classOpSignParamArray2D, 
                this.OpSignPlatArray2D, this.OpSignPlatlistNome, this.PlataformaDaEntidade, fsa, context));
          } else {
            this.classGenerationController(e, resource, this.listPlatform, this.listFeat, this.classNomeOperation, this.classOpSignParamArray2D, 
              this.OpSignPlatArray2D, this.OpSignPlatlistNome, this.PlataformaDaEntidade, fsa, context);
          }
        }
      }
    }
  }
  
  public CharSequence compile(final Deploy d) {
    StringConcatenation _builder = new StringConcatenation();
    final ArrayList<String> listEntity = new ArrayList<String>();
    _builder.append("\t");
    final ArrayList<String> listPlatform = new ArrayList<String>();
    _builder.append("\tpublic void Deploy{");
    _builder.newLineIfNotEmpty();
    {
      EList<Platform> _entityToDeploy = d.getEntityToDeploy();
      for(final Platform pl : _entityToDeploy) {
        boolean _addAll = CollectionExtensions.<String>addAll(listEntity, pl.getEnt().getName());
        _builder.append(_addAll);
        _builder.append("\t  ");
        CharSequence _compileDeploy = this.compileDeploy(pl, listPlatform);
        _builder.append(_compileDeploy);
        _builder.append("\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ----------------------------------------Recursos Platform--------------------------------------------------
   */
  public CharSequence compileDeploy(final Platform plat, final ArrayList<String> listEnt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Entidade: ");
    String _name = plat.getEnt().getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    _builder.append("Plataforma: ");
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(plat.getPlat());
    _builder.append(_fullyQualifiedName);
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ----------------------------------------Recursos Platform--------------------------------------------------
   */
  public CharSequence compileEntity(final Entity e, final Resource resource, final ArrayList<String> listPlat, final ArrayList<String> listFeatures, final ArrayList<String> classNomeOperation, final String[][] classOpSignParamArray2D, final String[][] OpSignPlatArray2D, final ArrayList<String> OpSignPlatlistNome, final String PlataformaDaEntidade, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    Boolean PlatEntity = Boolean.valueOf(false);
    _builder.newLineIfNotEmpty();
    {
      QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(e.eContainer());
      boolean _tripleNotEquals = (_fullyQualifiedName != null);
      if (_tripleNotEquals) {
        _builder.append("package ");
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(e.eContainer());
        _builder.append(_fullyQualifiedName_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append(" ");
    {
      Entity _superType = e.getSuperType();
      boolean _tripleNotEquals_1 = (_superType != null);
      if (_tripleNotEquals_1) {
        _builder.append(" extends ");
        QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(e.getSuperType());
        _builder.append(_fullyQualifiedName_2);
        _builder.append(" ");
      }
    }
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<CommandFeature> _features = e.getFeatures();
      for(final CommandFeature cmd : _features) {
        String _xblockexpression = null;
        {
          PlatEntity = Boolean.valueOf(false);
          _xblockexpression = "";
        }
        _builder.append(_xblockexpression);
        _builder.newLineIfNotEmpty();
        CharSequence _compileEntityCmd = this.compileEntityCmd(cmd, e, resource, listPlat, listFeatures, classNomeOperation, classOpSignParamArray2D, OpSignPlatArray2D, OpSignPlatlistNome, PlatEntity, PlataformaDaEntidade, fsa, context);
        _builder.append(_compileEntityCmd);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      Iterable<PlatformDecl> _filter = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), PlatformDecl.class);
      for(final PlatformDecl pe : _filter) {
        {
          String _string = pe.getName().toString();
          String _string_1 = PlataformaDaEntidade.toString();
          boolean _tripleEquals = (_string == _string_1);
          if (_tripleEquals) {
            {
              EList<CommandPlat> _cmdList = pe.getCmdList();
              for(final CommandPlat cmdOpPlat : _cmdList) {
                String _xblockexpression_1 = null;
                {
                  PlatEntity = Boolean.valueOf(true);
                  _xblockexpression_1 = "";
                }
                _builder.append(_xblockexpression_1);
                _builder.newLineIfNotEmpty();
                CharSequence _compilePlatCmd = this.compilePlatCmd(cmdOpPlat, e, resource, listPlat, listFeatures, classNomeOperation, classOpSignParamArray2D, OpSignPlatArray2D, OpSignPlatlistNome, PlatEntity);
                _builder.append(_compilePlatCmd);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ----------------------------------------Operation(M�todos)--------------------------------------------------
   */
  public CharSequence compileOperation(final Operation op, final ArrayList<String> classNomeOperation, final String[][] classOpSignParamArray2D) {
    StringConcatenation _builder = new StringConcatenation();
    int countOperation = 0;
    _builder.newLineIfNotEmpty();
    {
      int _size = classNomeOperation.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer iOp : _doubleDotLessThan) {
        String _xblockexpression = null;
        {
          countOperation++;
          _xblockexpression = "";
        }
        _builder.append(_xblockexpression);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, countOperation, true);
      for(final Integer i : _doubleDotLessThan_1) {
        {
          String _string = op.getName().toString();
          String _string_1 = classNomeOperation.get((i).intValue()).toString();
          boolean _equals = Objects.equal(_string, _string_1);
          if (_equals) {
            int cpClassOP = 0;
            _builder.newLineIfNotEmpty();
            {
              int _size_1 = ((List<String>)Conversions.doWrapArray((classOpSignParamArray2D[(i).intValue()]))).size();
              ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_1, true);
              for(final Integer cParam : _doubleDotLessThan_2) {
                {
                  String _get = (classOpSignParamArray2D[(i).intValue()])[(cParam).intValue()];
                  boolean _tripleNotEquals = (_get != null);
                  if (_tripleNotEquals) {
                    String _xblockexpression_1 = null;
                    {
                      cpClassOP++;
                      _xblockexpression_1 = "";
                    }
                    _builder.append(_xblockexpression_1);
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _equals_1 = this.verifyOpEntName(op).equals(op.getName());
              if (_equals_1) {
                _builder.append("public ");
                String _name = op.getName();
                _builder.append(_name);
                _builder.append("(");
                {
                  int _size_2 = ((List<String>)Conversions.doWrapArray((classOpSignParamArray2D[(i).intValue()]))).size();
                  ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_2, true);
                  for(final Integer c1 : _doubleDotLessThan_3) {
                    {
                      String _get_1 = (classOpSignParamArray2D[(i).intValue()])[(c1).intValue()];
                      boolean _tripleNotEquals_1 = (_get_1 != null);
                      if (_tripleNotEquals_1) {
                        String _string_2 = ((classOpSignParamArray2D[(i).intValue()])[(c1).intValue()]).toString();
                        _builder.append(_string_2);
                      }
                    }
                    {
                      if ((((c1).intValue() + 1) < cpClassOP)) {
                        _builder.append(", ");
                      }
                    }
                  }
                }
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("public ");
                String _prepareParametersReturn = this.prepareParametersReturn(op);
                _builder.append(_prepareParametersReturn);
                {
                  int _size_3 = op.getGenericTypesDecl().size();
                  boolean _greaterThan = (_size_3 > 0);
                  if (_greaterThan) {
                    _builder.append("<");
                    {
                      int _size_4 = op.getGenericTypesDecl().size();
                      ExclusiveRange _doubleDotLessThan_4 = new ExclusiveRange(0, _size_4, true);
                      for(final Integer c2 : _doubleDotLessThan_4) {
                        String _firstUpper = StringExtensions.toFirstUpper(op.getGenericTypesDecl().get((c2).intValue()).getName());
                        _builder.append(_firstUpper);
                        {
                          int _size_5 = op.getGenericTypesDecl().size();
                          boolean _lessThan = (((c2).intValue() + 1) < _size_5);
                          if (_lessThan) {
                            _builder.append(", ");
                          }
                        }
                      }
                    }
                    _builder.append(">");
                  }
                }
                {
                  String _col1 = op.getCol1();
                  boolean _tripleEquals = (_col1 == null);
                  boolean _not = (!_tripleEquals);
                  if (_not) {
                    _builder.append("[]");
                  }
                }
                _builder.append(" ");
                String _name_1 = op.getName();
                _builder.append(_name_1);
                _builder.append("(");
                {
                  int _size_6 = ((List<String>)Conversions.doWrapArray((classOpSignParamArray2D[(i).intValue()]))).size();
                  ExclusiveRange _doubleDotLessThan_5 = new ExclusiveRange(0, _size_6, true);
                  for(final Integer c1_1 : _doubleDotLessThan_5) {
                    {
                      String _get_2 = (classOpSignParamArray2D[(i).intValue()])[(c1_1).intValue()];
                      boolean _tripleNotEquals_2 = (_get_2 != null);
                      if (_tripleNotEquals_2) {
                        String _string_3 = ((classOpSignParamArray2D[(i).intValue()])[(c1_1).intValue()]).toString();
                        _builder.append(_string_3);
                      }
                    }
                    {
                      if ((((c1_1).intValue() + 1) < cpClassOP)) {
                        _builder.append(", ");
                      }
                    }
                  }
                }
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              EList<CommandOperation> _cmdList = op.getCmdList();
              for(final CommandOperation cmdOp : _cmdList) {
                CharSequence _compileOperationCmd = this.compileOperationCmd(cmdOp);
                _builder.append(_compileOperationCmd);
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public String prepareParametersReturn(final Operation op) {
    String listType = "";
    int _size = op.getGenericTypesDecl().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c2 : _doubleDotLessThan) {
      String _firstUpper = StringExtensions.toFirstUpper(op.getGenericTypesDecl().get((c2).intValue()).getName());
      String _plus = (listType + _firstUpper);
      listType = _plus;
    }
    boolean _equals = Objects.equal(listType, "");
    if (_equals) {
      return this.treatVariableName(this.compileType(op.getType()));
    } else {
      return this.treatVariableName(this.compileType(op.getType()));
    }
  }
  
  public String treatVariableName(final String variable) {
    boolean _equals = Objects.equal(variable, "int");
    if (_equals) {
      InputOutput.<String>println((" teste 1 : " + variable));
      return "Integer";
    } else {
      boolean _equals_1 = Objects.equal(variable, "void");
      if (_equals_1) {
        InputOutput.<String>println((" teste 2 : " + variable));
        return StringExtensions.toFirstLower(variable);
      } else {
        InputOutput.<String>println((" teste 3 : " + variable));
        return StringExtensions.toFirstUpper(variable);
      }
    }
  }
  
  /**
   * def prepareParametersReturn(Operation op){
   * if (op.genericTypesDecl === null){
   * return treatVariableName(op.type.compileType.toString)
   * }else{
   * 
   * if (op.type.compileType == "void" || op.type.compileType == "Void"){
   * return treatVariableName(op.type.compileType.toFirstLower)
   * }else{
   * return op.type.compileType.toFirstUpper
   * }
   * }
   * }
   */
  public String verifyOpEntName(final Operation op) {
    String entityName = "";
    EObject parent = op.eContainer();
    if ((parent instanceof Entity)) {
      entityName = ((Entity)parent).getName();
    }
    return entityName;
  }
  
  public String compileType(final DSLTypeRef typeRef) {
    boolean _matched = false;
    if (typeRef instanceof DSLConcreteTypeRef) {
      _matched=true;
      return this.specificReturnVariableGlogal(((DSLConcreteTypeRef)typeRef).getRef().getName());
    }
    if (!_matched) {
      if (typeRef instanceof DSLGenericTypeRef) {
        _matched=true;
        return this.specificReturnVariableGlogal(((DSLGenericTypeRef)typeRef).getRef().getName());
      }
    }
    return null;
  }
  
  public CharSequence compileOperationCmd(final CommandOperation cmdOp) {
    CharSequence _xifexpression = null;
    if ((cmdOp instanceof Attribute)) {
      _xifexpression = this.compileFeature(((Attribute)cmdOp));
    } else {
      CharSequence _xifexpression_1 = null;
      if ((cmdOp instanceof StringTemplateFreeCod)) {
        _xifexpression_1 = this.compileStringTemplateFreeCod(((StringTemplateFreeCod)cmdOp));
      } else {
        CharSequence _xifexpression_2 = null;
        if ((cmdOp instanceof MethodCallGlobal)) {
          CharSequence _xifexpression_3 = null;
          MethodCallGlob _call1 = ((MethodCallGlobal)cmdOp).getCall1();
          boolean _tripleNotEquals = (_call1 != null);
          if (_tripleNotEquals) {
            _xifexpression_3 = this.compileMethodCallGlob(((MethodCallGlobal)cmdOp).getCall1());
          } else {
            CharSequence _xifexpression_4 = null;
            MethodCallOp _call2 = ((MethodCallGlobal)cmdOp).getCall2();
            boolean _tripleNotEquals_1 = (_call2 != null);
            if (_tripleNotEquals_1) {
              _xifexpression_4 = this.compileMethodCallOp(((MethodCallGlobal)cmdOp).getCall2());
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        } else {
          CharSequence _xifexpression_5 = null;
          if ((cmdOp instanceof AbrevCmd)) {
            _xifexpression_5 = this.compileAbrevCmd(((AbrevCmd)cmdOp));
          } else {
            CharSequence _xifexpression_6 = null;
            if ((cmdOp instanceof MethodCallCmd)) {
              _xifexpression_6 = this.compileMethodCallCmd(((MethodCallCmd)cmdOp));
            } else {
              CharSequence _xifexpression_7 = null;
              if ((cmdOp instanceof CallAttributeObject)) {
                _xifexpression_7 = this.compileCallAttributeObject(((CallAttributeObject)cmdOp));
              } else {
                CharSequence _xifexpression_8 = null;
                if ((cmdOp instanceof OpLogicoWhile)) {
                  _xifexpression_8 = this.compileOpLogico(((OpLogicoWhile)cmdOp));
                } else {
                  CharSequence _xifexpression_9 = null;
                  if ((cmdOp instanceof OpLogicoDoWhile)) {
                    _xifexpression_9 = this.compileOpLogicoDoWhile(((OpLogicoDoWhile)cmdOp));
                  } else {
                    CharSequence _xifexpression_10 = null;
                    if ((cmdOp instanceof OpLogicoIF)) {
                      _xifexpression_10 = this.compileOpLogicoIf(((OpLogicoIF)cmdOp));
                    } else {
                      CharSequence _xifexpression_11 = null;
                      if ((cmdOp instanceof OpLogicoFor)) {
                        _xifexpression_11 = this.compileOpLogicoFor(((OpLogicoFor)cmdOp));
                      } else {
                        CharSequence _xifexpression_12 = null;
                        if ((cmdOp instanceof SpecialCommand)) {
                          _xifexpression_12 = this.compileSpecialCommand(((SpecialCommand)cmdOp));
                        }
                        _xifexpression_11 = _xifexpression_12;
                      }
                      _xifexpression_10 = _xifexpression_11;
                    }
                    _xifexpression_9 = _xifexpression_10;
                  }
                  _xifexpression_8 = _xifexpression_9;
                }
                _xifexpression_7 = _xifexpression_8;
              }
              _xifexpression_6 = _xifexpression_7;
            }
            _xifexpression_5 = _xifexpression_6;
          }
          _xifexpression_2 = _xifexpression_5;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * def compileCallAttributeObject(CallAttributeObject cmd) '''
   * �var varArray=""�
   * �IF(!(cmd.col1===null))�
   * �{varArray="["+ cmd.array + "]" ""}�
   * �ELSE�
   * �varArray=""�
   * �ENDIF�
   * �cmd.left.name��varArray� = �cmd.e.compileExpr�;
   * '''
   */
  public CharSequence compileFeature(final Attribute cmd) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((Integer.valueOf(cmd.getArrayAllow()).equals(Integer.valueOf(0)) && (cmd.getConcreteTypes().size() == 0))) {
        {
          Type _type = cmd.getType();
          boolean _not = (!(_type instanceof Entity));
          if (_not) {
            _builder.append("   ");
            {
              String _string = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType()).toString();
              boolean _equals = Objects.equal(_string, "string");
              if (_equals) {
                String _firstUpper = StringExtensions.toFirstUpper(this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType()).toString());
                _builder.append(_firstUpper);
                _builder.append(" ");
              } else {
                QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType());
                _builder.append(_fullyQualifiedName);
                _builder.append(" ");
              }
            }
            String _name = cmd.getName();
            _builder.append(_name);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("   ");
            {
              String _string_1 = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType()).toString();
              boolean _equals_1 = Objects.equal(_string_1, "string");
              if (_equals_1) {
                String _firstUpper_1 = StringExtensions.toFirstUpper(this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType()).toString());
                _builder.append(_firstUpper_1);
                _builder.append(" ");
              } else {
                QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType());
                _builder.append(_fullyQualifiedName_1);
                _builder.append(" ");
              }
            }
            String _name_1 = cmd.getName();
            _builder.append(_name_1);
            _builder.append(" = new ");
            QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType());
            _builder.append(_fullyQualifiedName_2);
            _builder.append("();");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        if (((!Integer.valueOf(cmd.getArrayAllow()).equals(Integer.valueOf(0))) && (cmd.getConcreteTypes().size() == 0))) {
          _builder.append("   ");
          QualifiedName _fullyQualifiedName_3 = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType());
          _builder.append(_fullyQualifiedName_3);
          _builder.append("[] ");
          String _name_2 = cmd.getName();
          _builder.append(_name_2);
          _builder.append(" = new ");
          QualifiedName _fullyQualifiedName_4 = this._iQualifiedNameProvider.getFullyQualifiedName(cmd.getType());
          _builder.append(_fullyQualifiedName_4);
          _builder.append("[");
          int _arrayAllow = cmd.getArrayAllow();
          _builder.append(_arrayAllow);
          _builder.append("];");
          _builder.newLineIfNotEmpty();
        } else {
          int _size = cmd.getConcreteTypes().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("   ");
            String _firstUpper_2 = StringExtensions.toFirstUpper(cmd.getType().getName());
            _builder.append(_firstUpper_2);
            _builder.append("<");
            String _countAttributeConcrete = this.countAttributeConcrete(cmd);
            _builder.append(_countAttributeConcrete);
            _builder.append("> ");
            String _name_3 = cmd.getName();
            _builder.append(_name_3);
            _builder.append("  = new ArrayList<");
            String _countAttributeConcrete_1 = this.countAttributeConcrete(cmd);
            _builder.append(_countAttributeConcrete_1);
            _builder.append(">();");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String adjustTypeLanguage(final DataType atr) {
    boolean _equals = atr.getName().equals("int");
    if (_equals) {
      return "Integer";
    } else {
      boolean _equals_1 = atr.getName().equals("Int");
      if (_equals_1) {
        return "Integer";
      } else {
        return atr.getName();
      }
    }
  }
  
  public String countAttributeConcrete(final Attribute atr) {
    String attribute = "";
    String comma = "";
    int _size = atr.getConcreteTypes().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        if (((c).intValue() > 0)) {
          comma = ", ";
        }
        String _attribute = attribute;
        String _firstUpper = StringExtensions.toFirstUpper(this.compileConcreteTypes(atr.getConcreteTypes().get((c).intValue())));
        String _plus = (comma + _firstUpper);
        attribute = (_attribute + _plus);
      }
    }
    return attribute;
  }
  
  public String compileConcreteTypes(final Type t) {
    if ((t instanceof Attribute)) {
      return t.getName();
    } else {
      if ((t instanceof Entity)) {
        return ((Entity)t).getName();
      } else {
        if ((t instanceof DataType)) {
          return this.adjustTypeLanguage(((DataType)t));
        }
      }
    }
    return null;
  }
  
  public CharSequence compileStringTemplateFreeCod(final StringTemplateFreeCod opStr) {
    StringConcatenation _builder = new StringConcatenation();
    int _length = opStr.getValue().toString().length();
    final int TamString = (_length - 4);
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = opStr.getValue().toString().equals("[]");
      boolean _not = (!_equals);
      if (_not) {
        String _generateMethodBody = VelocityGenerator.generateMethodBody(opStr.getValue().toString().substring(4, TamString));
        _builder.append(_generateMethodBody);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compileAbrevCmd(final AbrevCmd cmd) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Attribute _expr1 = cmd.getExpr1();
      boolean _tripleNotEquals = (_expr1 != null);
      if (_tripleNotEquals) {
        String _name = cmd.getExpr1().getName();
        _builder.append(_name);
        String _opIn = cmd.getOpIn();
        _builder.append(_opIn);
      }
    }
    {
      if (((cmd.getExpr2() != null) && (cmd.getExpr3() != null))) {
        String _name_1 = cmd.getExpr2().getName();
        _builder.append(_name_1);
        String _opIn_1 = cmd.getOpIn();
        _builder.append(_opIn_1);
        CharSequence _compileExpr = this.compileExpr(cmd.getExpr3());
        _builder.append(_compileExpr);
      }
    }
    {
      if ((cmd instanceof AssignmentCmdFor)) {
        String _name_2 = ((AssignmentCmdFor)cmd).getLeft().getName();
        _builder.append(_name_2);
        _builder.append("=");
        CharSequence _compileExpr_1 = this.compileExpr(((AssignmentCmdFor)cmd).getE());
        _builder.append(_compileExpr_1);
      }
    }
    return _builder;
  }
  
  public CharSequence compileMethodCallCmd(final MethodCallCmd cmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    String _obj = cmd.getObj();
    _builder.append(_obj);
    {
      int _size = cmd.getCall().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer h : _doubleDotLessThan) {
        _builder.append(".");
        String _get = cmd.getCall().get((h).intValue());
        _builder.append(_get);
      }
    }
    _builder.append("(");
    {
      int _size_1 = cmd.getArgs().size();
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
      for(final Integer i : _doubleDotLessThan_1) {
        String _name = cmd.getArgs().get((i).intValue()).getName();
        _builder.append(_name);
        {
          EList<AttribID> _vAtr2 = cmd.getArgs().get((i).intValue()).getVAtr2();
          for(final AttribID vatr : _vAtr2) {
            _builder.append(".");
            String _name_1 = vatr.getName();
            _builder.append(_name_1);
          }
        }
        {
          int _size_2 = cmd.getArgs().size();
          boolean _greaterThan = (_size_2 > ((i).intValue() + 1));
          if (_greaterThan) {
            _builder.append(", ");
          }
        }
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileMethodCallGlob(final MethodCallGlob cmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    CharSequence _methodCallGlob = this.methodCallGlob(cmd);
    _builder.append(_methodCallGlob);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileMethodCallOp(final MethodCallOp cmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    CharSequence _methodCallOp = this.methodCallOp(cmd);
    _builder.append(_methodCallOp);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileCallAttributeObject(final CallAttributeObject cmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    String _name = cmd.getObj().getName();
    _builder.append(_name);
    String _compileVector = this.compileVector(cmd.getObj().getV());
    _builder.append(_compileVector);
    {
      int _size = cmd.getCall().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append(".");
        String _name_1 = cmd.getCall().get((i).intValue()).getName();
        _builder.append(_name_1);
        String _compileVector_1 = this.compileVector(cmd.getCall().get((i).intValue()).getV());
        _builder.append(_compileVector_1);
      }
    }
    _builder.append(" = ");
    CharSequence _compileExpr = this.compileExpr(cmd.getE());
    _builder.append(_compileExpr);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String compileVector(final Vector v) {
    String varArray = "";
    String _col1 = v.getCol1();
    boolean _tripleEquals = (_col1 == null);
    boolean _not = (!_tripleEquals);
    if (_not) {
      int _array = v.getArray();
      String _plus = ("[" + Integer.valueOf(_array));
      String _plus_1 = (_plus + "]");
      return varArray = _plus_1;
    } else {
      return varArray = "";
    }
  }
  
  public CharSequence compileSpecialCommand(final SpecialCommand cmd) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _command = cmd.getCommand();
      boolean _tripleNotEquals = (_command != null);
      if (_tripleNotEquals) {
        _builder.append("   ");
        String _command_1 = cmd.getCommand();
        _builder.append(_command_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        Attribute _attr = cmd.getAttr();
        boolean _tripleNotEquals_1 = (_attr != null);
        if (_tripleNotEquals_1) {
          _builder.append("   ");
          _builder.append("return ");
          String _name = cmd.getAttr().getName();
          _builder.append(_name);
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileOpLogico(final OpLogicoWhile opCmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("while (");
    CharSequence _compileExpLogico = this.compileExpLogico(opCmd.getE());
    _builder.append(_compileExpLogico);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    {
      EList<CommandOperation> _cmdList = opCmd.getCmdList();
      for(final CommandOperation cmd2 : _cmdList) {
        _builder.append("   ");
        _builder.append("   ");
        Object _compileOperationCmd = this.compileOperationCmd(cmd2);
        _builder.append(_compileOperationCmd);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileOpLogicoDoWhile(final OpLogicoDoWhile opCmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("do {");
    _builder.newLineIfNotEmpty();
    {
      EList<CommandOperation> _cmdList = opCmd.getCmdList();
      for(final CommandOperation cmd2 : _cmdList) {
        _builder.append("   ");
        _builder.append("   ");
        Object _compileOperationCmd = this.compileOperationCmd(cmd2);
        _builder.append(_compileOperationCmd);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   ");
    _builder.append("}while(");
    CharSequence _compileExpLogico = this.compileExpLogico(opCmd.getE());
    _builder.append(_compileExpLogico);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileOpLogicoIf(final OpLogicoIF opCmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("if (");
    CharSequence _compileExpLogico = this.compileExpLogico(opCmd.getE());
    _builder.append(_compileExpLogico);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    {
      EList<CommandOperation> _cmdList = opCmd.getCmdList();
      for(final CommandOperation cmd2 : _cmdList) {
        _builder.append("   ");
        _builder.append("   ");
        Object _compileOperationCmd = this.compileOperationCmd(cmd2);
        _builder.append(_compileOperationCmd);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   ");
    _builder.append("}");
    {
      EList<OpElseIf> _opElseIf = opCmd.getOpElseIf();
      for(final OpElseIf cmdElseIf : _opElseIf) {
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("else if(");
        CharSequence _compileExpLogico_1 = this.compileExpLogico(cmdElseIf.getExpLog());
        _builder.append(_compileExpLogico_1);
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        {
          EList<CommandOperation> _cmdList_1 = cmdElseIf.getCmdList();
          for(final CommandOperation cmd3 : _cmdList_1) {
            _builder.append("   ");
            _builder.append("   ");
            Object _compileOperationCmd_1 = this.compileOperationCmd(cmd3);
            _builder.append(_compileOperationCmd_1);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("   ");
        _builder.append("}");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<OpElse> _opElse = opCmd.getOpElse();
      for(final OpElse cmdElse : _opElse) {
        _builder.append("   ");
        _builder.append("else{");
        _builder.newLineIfNotEmpty();
        {
          EList<CommandOperation> _cmdList_2 = cmdElse.getCmdList();
          for(final CommandOperation cmd3_1 : _cmdList_2) {
            _builder.append("   ");
            _builder.append("   ");
            Object _compileOperationCmd_2 = this.compileOperationCmd(cmd3_1);
            _builder.append(_compileOperationCmd_2);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("   ");
        _builder.append("}");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public String dictionaryJava(final String term) {
    boolean _equals = Objects.equal(term, "size");
    if (_equals) {
      return "size()";
    } else {
      return term;
    }
  }
  
  public CharSequence compileOpLogicoFor(final OpLogicoFor opCmd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for (");
    String _name = opCmd.getExprLogic().getInicio().getLeft().getName();
    _builder.append(_name);
    _builder.append("=");
    CharSequence _compileExpr = this.compileExpr(opCmd.getExprLogic().getInicio().getE());
    _builder.append(_compileExpr);
    _builder.append(";");
    CharSequence _compileExpLogico = this.compileExpLogico(opCmd.getExprLogic().getCondicao());
    _builder.append(_compileExpLogico);
    _builder.append(";");
    Object _compileOperationCmd = this.compileOperationCmd(opCmd.getExprLogic().getAbrevCmd());
    _builder.append(_compileOperationCmd);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    {
      EList<CommandOperation> _cmdList = opCmd.getCmdList();
      for(final CommandOperation cmd2 : _cmdList) {
        _builder.append("   ");
        _builder.append("   ");
        Object _compileOperationCmd_1 = this.compileOperationCmd(cmd2);
        _builder.append(_compileOperationCmd_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ---------------Express�es l�gicas--------------
   */
  public CharSequence compileExpLogico(final ExprLogica exprLog) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = exprLog.getTermos().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        {
          if (((i).intValue() > 0)) {
            _builder.append(" ");
            String _compileOpLog = this.compileOpLog(exprLog.getOplog().get(((i).intValue() - 1)));
            _builder.append(_compileOpLog);
            _builder.append(" ");
          }
        }
        CharSequence _compileTermoLogico = this.compileTermoLogico(exprLog.getTermos().get((i).intValue()));
        _builder.append(_compileTermoLogico);
      }
    }
    return _builder;
  }
  
  public CharSequence compileTermoLogico(final TermoLogico termoLog) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = termoLog.getFatores().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        {
          if (((i).intValue() > 0)) {
            _builder.append(" ");
            String _compileOpLog = this.compileOpLog(termoLog.getOplog().get(((i).intValue() - 1)));
            _builder.append(_compileOpLog);
            _builder.append(" ");
          }
        }
        CharSequence _compileFatorLog = this.compileFatorLog(termoLog.getFatores().get((i).intValue()));
        _builder.append(_compileFatorLog);
      }
    }
    return _builder;
  }
  
  public CharSequence compileFatorLog(final FatorLogico fatorLog) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Attribute _v = fatorLog.getV();
      boolean _tripleEquals = (_v == null);
      if (_tripleEquals) {
        {
          String _op1 = fatorLog.getOp1();
          boolean _tripleNotEquals = (_op1 != null);
          if (_tripleNotEquals) {
            String _op1_1 = fatorLog.getOp1();
            _builder.append(_op1_1);
          } else {
            String _op2 = fatorLog.getOp2();
            boolean _tripleNotEquals_1 = (_op2 != null);
            if (_tripleNotEquals_1) {
              String _op2_1 = fatorLog.getOp2();
              _builder.append(_op2_1);
            } else {
              String _opRel = fatorLog.getOpRel();
              boolean _tripleNotEquals_2 = (_opRel != null);
              if (_tripleNotEquals_2) {
                {
                  int _i = fatorLog.getExpr1().getI();
                  boolean _notEquals = (_i != 0);
                  if (_notEquals) {
                    int _i_1 = fatorLog.getExpr1().getI();
                    _builder.append(_i_1);
                    {
                      int _iD = fatorLog.getExpr1().getID();
                      boolean _notEquals_1 = (_iD != 0);
                      if (_notEquals_1) {
                        _builder.append(".");
                        int _iD_1 = fatorLog.getExpr1().getID();
                        _builder.append(_iD_1);
                      }
                    }
                  } else {
                    String _strVar = fatorLog.getExpr1().getStrVar();
                    boolean _tripleNotEquals_3 = (_strVar != null);
                    if (_tripleNotEquals_3) {
                      _builder.append("\"");
                      String _strVar_1 = fatorLog.getExpr1().getStrVar();
                      _builder.append(_strVar_1);
                      _builder.append("\"");
                    } else {
                      String _vAtr1 = fatorLog.getExpr1().getVAtr1();
                      boolean _tripleNotEquals_4 = (_vAtr1 != null);
                      if (_tripleNotEquals_4) {
                        String _vAtr1_1 = fatorLog.getExpr1().getVAtr1();
                        _builder.append(_vAtr1_1);
                        {
                          int _size = fatorLog.getExpr1().getVAtr2().size();
                          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                          for(final Integer i : _doubleDotLessThan) {
                            _builder.append(".");
                            String _string = fatorLog.getExpr1().getVAtr2().get((i).intValue()).getName().toString();
                            _builder.append(_string);
                          }
                        }
                      } else {
                        {
                          String _v_1 = fatorLog.getExpr1().getV();
                          boolean _tripleEquals_1 = (_v_1 == null);
                          if (_tripleEquals_1) {
                            int _i_2 = fatorLog.getExpr1().getI();
                            _builder.append(_i_2);
                            {
                              int _iD_2 = fatorLog.getExpr1().getID();
                              boolean _notEquals_2 = (_iD_2 != 0);
                              if (_notEquals_2) {
                                _builder.append(".");
                                int _iD_3 = fatorLog.getExpr1().getID();
                                _builder.append(_iD_3);
                              }
                            }
                          } else {
                            String _v_2 = fatorLog.getExpr1().getV();
                            _builder.append(_v_2);
                          }
                        }
                        {
                          String _col1 = fatorLog.getExpr1().getCol1();
                          boolean _tripleEquals_2 = (_col1 == null);
                          boolean _not = (!_tripleEquals_2);
                          if (_not) {
                            _builder.append("[");
                            int _array = fatorLog.getExpr1().getArray();
                            _builder.append(_array);
                            _builder.append("]");
                          }
                        }
                      }
                    }
                  }
                }
                String _relOperators = this.relOperators(fatorLog);
                _builder.append(_relOperators);
                {
                  int _i_3 = fatorLog.getExpr2().getI();
                  boolean _notEquals_3 = (_i_3 != 0);
                  if (_notEquals_3) {
                    int _i_4 = fatorLog.getExpr2().getI();
                    _builder.append(_i_4);
                    {
                      int _iD_4 = fatorLog.getExpr2().getID();
                      boolean _notEquals_4 = (_iD_4 != 0);
                      if (_notEquals_4) {
                        _builder.append(".");
                        int _iD_5 = fatorLog.getExpr2().getID();
                        _builder.append(_iD_5);
                      }
                    }
                  } else {
                    String _strVar_2 = fatorLog.getExpr2().getStrVar();
                    boolean _tripleNotEquals_5 = (_strVar_2 != null);
                    if (_tripleNotEquals_5) {
                      _builder.append("\"");
                      String _strVar_3 = fatorLog.getExpr2().getStrVar();
                      _builder.append(_strVar_3);
                      _builder.append("\"");
                    } else {
                      String _vAtr1_2 = fatorLog.getExpr2().getVAtr1();
                      boolean _tripleNotEquals_6 = (_vAtr1_2 != null);
                      if (_tripleNotEquals_6) {
                        String _vAtr1_3 = fatorLog.getExpr2().getVAtr1();
                        _builder.append(_vAtr1_3);
                        {
                          int _size_1 = fatorLog.getExpr2().getVAtr2().size();
                          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
                          for(final Integer i_1 : _doubleDotLessThan_1) {
                            _builder.append(".");
                            String _dictionaryJava = this.dictionaryJava(fatorLog.getExpr2().getVAtr2().get((i_1).intValue()).getName().toString());
                            _builder.append(_dictionaryJava);
                          }
                        }
                      } else {
                        {
                          String _v_3 = fatorLog.getExpr2().getV();
                          boolean _tripleEquals_3 = (_v_3 == null);
                          if (_tripleEquals_3) {
                            int _i_5 = fatorLog.getExpr2().getI();
                            _builder.append(_i_5);
                            {
                              int _iD_6 = fatorLog.getExpr2().getID();
                              boolean _notEquals_5 = (_iD_6 != 0);
                              if (_notEquals_5) {
                                _builder.append(".");
                                int _iD_7 = fatorLog.getExpr2().getID();
                                _builder.append(_iD_7);
                              }
                            }
                          } else {
                            String _strVar_4 = fatorLog.getExpr2().getStrVar();
                            boolean _tripleNotEquals_7 = (_strVar_4 != null);
                            if (_tripleNotEquals_7) {
                              String _strVar_5 = fatorLog.getExpr2().getStrVar();
                              _builder.append(_strVar_5);
                            } else {
                              String _v_4 = fatorLog.getExpr2().getV();
                              _builder.append(_v_4);
                            }
                          }
                        }
                        {
                          String _col1_1 = fatorLog.getExpr2().getCol1();
                          boolean _tripleEquals_4 = (_col1_1 == null);
                          boolean _not_1 = (!_tripleEquals_4);
                          if (_not_1) {
                            _builder.append("[");
                            int _array_1 = fatorLog.getExpr2().getArray();
                            _builder.append(_array_1);
                            _builder.append("]");
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } else {
        String _name = fatorLog.getV().getName();
        _builder.append(_name);
      }
    }
    {
      if (((((fatorLog.getOpRel() == null) && (fatorLog.getOp1() == null)) && (fatorLog.getOp2() == null)) && (fatorLog.getV() == null))) {
        _builder.append("(");
        Object _compileExpLogico = this.compileExpLogico(fatorLog.getExprLog());
        _builder.append(_compileExpLogico);
        _builder.append(")");
      }
    }
    return _builder;
  }
  
  public String compileOpLog(final String opL) {
    return opL;
  }
  
  /**
   * ---------------Express�es l�gicas--------------
   */
  public String relOperators(final FatorLogico fLog) {
    String _opRel = fLog.getOpRel();
    String _plus = (" Saida RelOpe: " + _opRel);
    InputOutput.<String>println(_plus);
    boolean _equals = fLog.getOpRel().toString().equals("<>");
    if (_equals) {
      return "!=";
    } else {
      return fLog.getOpRel();
    }
  }
  
  /**
   * ---------------Express�es aritim�ticas--------------
   */
  public CharSequence compileExpr(final ExprArit exp) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = exp.getTermos().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        {
          if (((i).intValue() > 0)) {
            String _compileOp = this.compileOp(exp.getOp().get(((i).intValue() - 1)));
            _builder.append(_compileOp);
          }
        }
        CharSequence _compileTermo = this.compileTermo(exp.getTermos().get((i).intValue()));
        _builder.append(_compileTermo);
      }
    }
    return _builder;
  }
  
  public CharSequence compileTermo(final Termo termo) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = termo.getFatores().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        {
          if (((i).intValue() > 0)) {
            String _compileOp = this.compileOp(termo.getOp().get(((i).intValue() - 1)));
            _builder.append(_compileOp);
          }
        }
        CharSequence _compileFator = this.compileFator(termo.getFatores().get((i).intValue()));
        _builder.append(_compileFator);
      }
    }
    return _builder;
  }
  
  public CharSequence compileFator(final Fator fator) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((((((fator.getV() == null) && (fator.getExpr() == null)) && (fator.getStrVar() == null)) && (fator.getVAtr1() == null)) && (fator.getMcOperation() == null)) && (fator.getMcGlobal() == null))) {
        String _string = fator.getD().toString();
        _builder.append(_string);
      } else {
        {
          if ((((((fator.getExpr() == null) && (fator.getStrVar() == null)) && (fator.getVAtr1() == null)) && (fator.getMcOperation() == null)) && (fator.getMcGlobal() == null))) {
            String _v = fator.getV();
            _builder.append(_v);
            {
              String _col1 = fator.getCol1();
              boolean _tripleEquals = (_col1 == null);
              boolean _not = (!_tripleEquals);
              if (_not) {
                {
                  String _array2 = fator.getArray2();
                  boolean _tripleEquals_1 = (_array2 == null);
                  if (_tripleEquals_1) {
                    _builder.append("[");
                    int _array = fator.getArray();
                    _builder.append(_array);
                    _builder.append("]");
                  } else {
                    _builder.append("[");
                    String _array2_1 = fator.getArray2();
                    _builder.append(_array2_1);
                    _builder.append("]");
                  }
                }
              }
            }
          } else {
            if (((((fator.getStrVar() == null) && (fator.getVAtr1() == null)) && (fator.getMcOperation() == null)) && (fator.getMcGlobal() == null))) {
              _builder.append("(");
              Object _compileExpr = this.compileExpr(fator.getExpr());
              _builder.append(_compileExpr);
              _builder.append(")");
            } else {
              if ((((fator.getVAtr1() == null) && (fator.getMcOperation() == null)) && (fator.getMcGlobal() == null))) {
                _builder.append("\"");
                String _strVar = fator.getStrVar();
                _builder.append(_strVar);
                _builder.append("\"");
              } else {
                if ((((fator.getVAtr1() != null) && (fator.getMcOperation() == null)) && (fator.getMcGlobal() == null))) {
                  String _name = fator.getVAtr1().getName();
                  _builder.append(_name);
                  {
                    int _size = fator.getVAtr2().size();
                    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                    for(final Integer y : _doubleDotLessThan) {
                      _builder.append(".");
                      String _dictionaryJava = this.dictionaryJava(fator.getVAtr2().get((y).intValue()).getName());
                      _builder.append(_dictionaryJava);
                      {
                        int _size_1 = fator.getCol().size();
                        boolean _lessThan = ((y).intValue() < _size_1);
                        if (_lessThan) {
                          _builder.append("(");
                          {
                            String _string_1 = fator.getValue().toString();
                            boolean _notEquals = (!Objects.equal(_string_1, "[]"));
                            if (_notEquals) {
                              {
                                int _i = fator.getValue().get((y).intValue()).getI();
                                boolean _notEquals_1 = (_i != 0);
                                if (_notEquals_1) {
                                  int _i_1 = fator.getValue().get((y).intValue()).getI();
                                  _builder.append(_i_1);
                                  {
                                    int _iD = fator.getValue().get((y).intValue()).getID();
                                    boolean _notEquals_2 = (_iD != 0);
                                    if (_notEquals_2) {
                                      _builder.append(".");
                                      int _iD_1 = fator.getValue().get((y).intValue()).getID();
                                      _builder.append(_iD_1);
                                    }
                                  }
                                } else {
                                  String _vAtr1 = fator.getValue().get((y).intValue()).getVAtr1();
                                  boolean _tripleNotEquals = (_vAtr1 != null);
                                  if (_tripleNotEquals) {
                                    String _vAtr1_1 = fator.getValue().get((y).intValue()).getVAtr1();
                                    _builder.append(_vAtr1_1);
                                    {
                                      int _size_2 = fator.getValue().get((y).intValue()).getVAtr2().size();
                                      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
                                      for(final Integer z : _doubleDotLessThan_1) {
                                        _builder.append(".");
                                        String _dictionaryJava_1 = this.dictionaryJava(fator.getValue().get((y).intValue()).getVAtr2().get((z).intValue()).getName());
                                        _builder.append(_dictionaryJava_1);
                                      }
                                    }
                                  } else {
                                    {
                                      String _v_1 = fator.getValue().get((y).intValue()).getV();
                                      boolean _tripleEquals_2 = (_v_1 == null);
                                      if (_tripleEquals_2) {
                                        int _i_2 = fator.getValue().get((y).intValue()).getI();
                                        _builder.append(_i_2);
                                        {
                                          int _iD_2 = fator.getValue().get((y).intValue()).getID();
                                          boolean _notEquals_3 = (_iD_2 != 0);
                                          if (_notEquals_3) {
                                            _builder.append(".");
                                            int _iD_3 = fator.getValue().get((y).intValue()).getID();
                                            _builder.append(_iD_3);
                                          }
                                        }
                                      } else {
                                        String _v_2 = fator.getValue().get((y).intValue()).getV();
                                        _builder.append(_v_2);
                                      }
                                    }
                                    {
                                      String _col1_1 = fator.getValue().get((y).intValue()).getCol1();
                                      boolean _tripleEquals_3 = (_col1_1 == null);
                                      boolean _not_1 = (!_tripleEquals_3);
                                      if (_not_1) {
                                        _builder.append("[");
                                        int _array_1 = fator.getValue().get((y).intValue()).getArray();
                                        _builder.append(_array_1);
                                        _builder.append("]");
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                          _builder.append(")");
                        }
                      }
                    }
                  }
                } else {
                  MethodCallGlob _mcGlobal = fator.getMcGlobal();
                  boolean _tripleEquals_4 = (_mcGlobal == null);
                  if (_tripleEquals_4) {
                    CharSequence _methodCallOp = this.methodCallOp(fator.getMcOperation());
                    _builder.append(_methodCallOp);
                  } else {
                    MethodCallGlob _mcGlobal_1 = fator.getMcGlobal();
                    boolean _tripleNotEquals_1 = (_mcGlobal_1 != null);
                    if (_tripleNotEquals_1) {
                      CharSequence _methodCallGlob = this.methodCallGlob(fator.getMcGlobal());
                      _builder.append(_methodCallGlob);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public String compileOp(final String op) {
    return op;
  }
  
  /**
   * ---------------Express�es aritim�ticas--------------
   */
  public CharSequence methodCallGlob(final MethodCallGlob mCGlobal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Attribute _obj = mCGlobal.getObj();
      boolean _tripleNotEquals = (_obj != null);
      if (_tripleNotEquals) {
        String _string = mCGlobal.getObj().getName().toString();
        _builder.append(_string);
        _builder.append(".");
      }
    }
    String _name = mCGlobal.getCalledOpGlobal().getName();
    _builder.append(_name);
    _builder.append("(");
    {
      int _size = mCGlobal.getArgs().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        String _name_1 = mCGlobal.getArgs().get((i).intValue()).getName();
        _builder.append(_name_1);
        {
          String _col1 = mCGlobal.getArgs().get((i).intValue()).getCol1();
          boolean _tripleEquals = (_col1 == null);
          boolean _not = (!_tripleEquals);
          if (_not) {
            _builder.append("[");
            int _array = mCGlobal.getArgs().get((i).intValue()).getArray();
            _builder.append(_array);
            _builder.append("]");
          }
        }
        {
          int _size_1 = mCGlobal.getArgs().size();
          boolean _lessThan = (((i).intValue() + 1) < _size_1);
          if (_lessThan) {
            _builder.append(", ");
          }
        }
      }
    }
    {
      String _verifyArg = this.verifyArg(mCGlobal);
      boolean _tripleNotEquals_1 = (_verifyArg != "");
      if (_tripleNotEquals_1) {
        {
          int _size_2 = mCGlobal.getArgs().size();
          boolean _greaterThan = (_size_2 > 0);
          if (_greaterThan) {
            _builder.append(", ");
          }
        }
        String _verifyArg_1 = this.verifyArg(mCGlobal);
        _builder.append(_verifyArg_1);
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence methodCallOp(final MethodCallOp mCOp) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = mCOp.getCall().getName();
    _builder.append(_name);
    _builder.append("(");
    {
      int _size = mCOp.getArgs().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        String _name_1 = mCOp.getArgs().get((i).intValue()).getName();
        _builder.append(_name_1);
        {
          String _col1 = mCOp.getArgs().get((i).intValue()).getCol1();
          boolean _tripleEquals = (_col1 == null);
          boolean _not = (!_tripleEquals);
          if (_not) {
            _builder.append("[");
            int _array = mCOp.getArgs().get((i).intValue()).getArray();
            _builder.append(_array);
            _builder.append("]");
          }
        }
        {
          int _size_1 = mCOp.getArgs().size();
          boolean _lessThan = (((i).intValue() + 1) < _size_1);
          if (_lessThan) {
            _builder.append(", ");
          }
        }
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  public String verifyArg(final MethodCallGlob methodCallGlob) {
    String entity = "";
    String args = "";
    int verif = 0;
    final ArrayList<String> listParamUsesGlobal = new ArrayList<String>();
    listParamUsesGlobal.clear();
    entity = this.verifyEntityName(methodCallGlob);
    EObject metodoPai = methodCallGlob.eContainer();
    Iterable<Entity> _filter = Iterables.<Entity>filter(IteratorExtensions.<EObject>toIterable(this.res.getAllContents()), Entity.class);
    for (final Entity ent : _filter) {
      Attribute _obj = methodCallGlob.getObj();
      boolean _tripleNotEquals = (_obj != null);
      if (_tripleNotEquals) {
        String _name = methodCallGlob.getObj().getType().getName();
        String _name_1 = ent.getName();
        boolean _tripleEquals = (_name == _name_1);
        if (_tripleEquals) {
          EList<CommandFeature> _features = ent.getFeatures();
          for (final CommandFeature operat : _features) {
            if ((operat instanceof OperationGlobCallOld)) {
              String _name_2 = ((OperationGlobCallOld)operat).getOpGlobCall().getName();
              String _name_3 = methodCallGlob.getCalledOpGlobal().getName();
              boolean _equals = Objects.equal(_name_2, _name_3);
              if (_equals) {
                EList<Parameter> _params = ((OperationGlobCallOld)operat).getParams();
                for (final Parameter p : _params) {
                  CollectionExtensions.<String>addAll(listParamUsesGlobal, p.getName());
                }
              }
            }
          }
        }
      } else {
        boolean _equals_1 = entity.equals(ent.getName());
        if (_equals_1) {
          EList<CommandFeature> _features_1 = ent.getFeatures();
          for (final CommandFeature operat_1 : _features_1) {
            if ((operat_1 instanceof OperationGlobCallOld)) {
              boolean _equals_2 = ((OperationGlobCallOld)operat_1).getOpGlobCall().getName().equals(methodCallGlob.getCalledOpGlobal().getName());
              if (_equals_2) {
                EList<Parameter> _params_1 = ((OperationGlobCallOld)operat_1).getParams();
                for (final Parameter p_1 : _params_1) {
                  CollectionExtensions.<String>addAll(listParamUsesGlobal, p_1.getName());
                }
              }
            }
          }
        }
      }
    }
    int _size = listParamUsesGlobal.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer y : _doubleDotLessThan) {
    }
    int verif2 = 0;
    int countComma = 0;
    Iterable<PlatformDecl> _filter_1 = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(this.res.getAllContents()), PlatformDecl.class);
    for (final PlatformDecl plat : _filter_1) {
      String _string = plat.getName().toString();
      boolean _tripleEquals_1 = (_string == this.platAtual);
      if (_tripleEquals_1) {
        EList<CommandPlat> _cmdList = plat.getCmdList();
        for (final CommandPlat platformOp : _cmdList) {
          if ((platformOp instanceof OperationGlobal)) {
            String _name_4 = methodCallGlob.getCalledOpGlobal().getName();
            String _string_1 = ((OperationGlobal)platformOp).getOpGlobal().getName().toString();
            boolean _equals_3 = Objects.equal(_name_4, _string_1);
            if (_equals_3) {
              int _size_1 = ((OperationGlobal)platformOp).getParams().size();
              ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
              for (final Integer z : _doubleDotLessThan_1) {
                DSLTypeRef _type = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getType();
                if ((_type instanceof DSLConcreteTypeRef)) {
                  verif = 0;
                  int _size_2 = listParamUsesGlobal.size();
                  ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_2, true);
                  for (final Integer y_1 : _doubleDotLessThan_2) {
                    boolean _equals_4 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString().equals(listParamUsesGlobal.get((y_1).intValue()).toString());
                    if (_equals_4) {
                      verif = 1;
                    }
                  }
                  if ((verif == 0)) {
                    verif2 = 0;
                    int _size_3 = methodCallGlob.getArgs().size();
                    ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_3, true);
                    for (final Integer q : _doubleDotLessThan_3) {
                      boolean _equals_5 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString().equals(methodCallGlob.getArgs().get((q).intValue()).getName().toString());
                      if (_equals_5) {
                        verif2 = 1;
                      }
                    }
                    if ((verif2 == 0)) {
                      if ((countComma == 0)) {
                        String _args = args;
                        String _string_2 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString();
                        args = (_args + _string_2);
                      } else {
                        String _args_1 = args;
                        String _string_3 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString();
                        String _plus = (", " + _string_3);
                        args = (_args_1 + _plus);
                      }
                      countComma++;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return args;
  }
  
  public String verifyEntityName(final MethodCallGlob methodCallGlob) {
    String args = "";
    EObject parent = methodCallGlob.eContainer();
    if ((parent instanceof Fator)) {
      EObject r1 = ((Fator)parent).eContainer();
      if ((r1 instanceof Termo)) {
        EObject r2 = ((Termo)r1).eContainer();
        if ((r2 instanceof ExprArit)) {
          EObject r3 = ((ExprArit)r2).eContainer();
          if ((r3 instanceof CallAttributeObject)) {
            EObject r4 = ((CallAttributeObject)r3).eContainer();
            if ((r4 instanceof CommandFeature)) {
              EObject r5 = ((CommandFeature)r4).eContainer();
              if ((r5 instanceof Entity)) {
                String _args = args;
                String _name = ((Entity)r5).getName();
                args = (_args + _name);
              }
            }
          } else {
            if ((r3 instanceof AssignmentCmdFor)) {
              EObject r6 = ((AssignmentCmdFor)r3).eContainer();
              if ((r6 instanceof OpElse)) {
                EObject r7 = ((OpElse)r6).eContainer();
                if ((r7 instanceof OpLogicoIF)) {
                  EObject r8 = ((OpLogicoIF)r7).eContainer();
                  if ((r8 instanceof OpLogicoIF)) {
                    EObject r9 = ((OpLogicoIF)r8).eContainer();
                    if ((r9 instanceof OpLogicoFor)) {
                      EObject r10 = ((OpLogicoFor)r9).eContainer();
                      if ((r10 instanceof Operation)) {
                        EObject r11 = ((Operation)r10).eContainer();
                        if ((r11 instanceof Entity)) {
                          String _args_1 = args;
                          String _name_1 = ((Entity)r11).getName();
                          args = (_args_1 + _name_1);
                        }
                      }
                    }
                  }
                }
              }
            } else {
              if ((r3 instanceof OpLogicoIF)) {
                EObject r12 = ((OpLogicoIF)r3).eContainer();
                if ((r12 instanceof CommandOperation)) {
                  EObject r13 = ((CommandOperation)r12).eContainer();
                  if ((r13 instanceof Operation)) {
                    EObject r14 = ((Operation)r13).eContainer();
                    if ((r14 instanceof Entity)) {
                      String _args_2 = args;
                      String _name_2 = ((Entity)r14).getName();
                      args = (_args_2 + _name_2);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return args;
  }
  
  public CharSequence compileEntityGlob(final EntityGlobCall entGlobalCall, final String PlataformaDaEntidade, final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<PlatformDecl> _filter = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), PlatformDecl.class);
      for(final PlatformDecl plat : _filter) {
        {
          String _string = plat.getName().toString();
          boolean _tripleEquals = (_string == PlataformaDaEntidade);
          if (_tripleEquals) {
            {
              EList<CommandPlat> _cmdList = plat.getCmdList();
              for(final CommandPlat platformOp : _cmdList) {
                {
                  if ((platformOp instanceof EntityGlobal)) {
                    {
                      String _string_1 = entGlobalCall.getOpGlobCall().getName().toString();
                      String _string_2 = ((EntityGlobal)platformOp).getOpGlobal().getName().toString();
                      boolean _equals = Objects.equal(_string_1, _string_2);
                      if (_equals) {
                        {
                          EList<CommandOperation> _cmdList_1 = ((EntityGlobal)platformOp).getCmdList();
                          for(final CommandOperation cmd : _cmdList_1) {
                            {
                              if ((cmd instanceof StringTemplateFreeCod)) {
                                CharSequence _compileStringTemplateFreeEntityGlobal = this.compileStringTemplateFreeEntityGlobal(((StringTemplateFreeCod)cmd).getValue().toString(), entGlobalCall, ((EntityGlobal)platformOp));
                                _builder.append(_compileStringTemplateFreeEntityGlobal);
                                _builder.newLineIfNotEmpty();
                              } else {
                                CharSequence _compileOperationCmd = this.compileOperationCmd(cmd);
                                _builder.append(_compileOperationCmd);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileControllerGlob(final OperationGlobCall contGlobalCall, final String PlataformaDaEntidade, final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<PlatformDecl> _filter = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), PlatformDecl.class);
      for(final PlatformDecl plat : _filter) {
        {
          String _string = plat.getName().toString();
          boolean _tripleEquals = (_string == PlataformaDaEntidade);
          if (_tripleEquals) {
            {
              EList<CommandPlat> _cmdList = plat.getCmdList();
              for(final CommandPlat platformOp : _cmdList) {
                {
                  if ((platformOp instanceof OperationGlobal)) {
                    {
                      String _string_1 = contGlobalCall.getOpGlobCall().getName().toString();
                      String _string_2 = ((OperationGlobal)platformOp).getOpGlobal().getName().toString();
                      boolean _equals = Objects.equal(_string_1, _string_2);
                      if (_equals) {
                        int verif = 0;
                        _builder.newLineIfNotEmpty();
                        int countComma = 0;
                        _builder.newLineIfNotEmpty();
                        int verifPlat = 0;
                        _builder.newLineIfNotEmpty();
                        {
                          int _size = this.platSeparatedController.size();
                          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                          for(final Integer j : _doubleDotLessThan) {
                            {
                              boolean _equals_1 = this.platSeparatedController.get((j).intValue()).equals(PlataformaDaEntidade);
                              if (_equals_1) {
                                String _xblockexpression = null;
                                {
                                  verifPlat = 1;
                                  _xblockexpression = "";
                                }
                                _builder.append(_xblockexpression);
                              }
                            }
                          }
                        }
                        _builder.newLineIfNotEmpty();
                        {
                          if ((Integer.valueOf(verifPlat).equals(Integer.valueOf(0)) && this.EntityPlatform.equals(this.varController))) {
                            _builder.append("public ");
                            String _compileType = this.compileType(contGlobalCall.getTypeGlobal());
                            _builder.append(_compileType);
                            {
                              String _col1 = ((OperationGlobal)platformOp).getCol1();
                              boolean _tripleEquals_1 = (_col1 == null);
                              boolean _not = (!_tripleEquals_1);
                              if (_not) {
                                _builder.append("[]");
                              }
                            }
                            _builder.append(" ");
                            String _name = contGlobalCall.getConcreteTypes().get(0).getName();
                            _builder.append(_name);
                            _builder.append("(");
                            {
                              int _size_1 = contGlobalCall.getParams().size();
                              ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
                              for(final Integer i : _doubleDotLessThan_1) {
                                String _compileType_1 = this.compileType(contGlobalCall.getParams().get((i).intValue()).getType());
                                String _plus = (_compileType_1 + " ");
                                String _name_1 = contGlobalCall.getParams().get((i).intValue()).getName();
                                String _plus_1 = (_plus + _name_1);
                                _builder.append(_plus_1);
                                String _xblockexpression_1 = null;
                                {
                                  countComma = 1;
                                  _xblockexpression_1 = "";
                                }
                                _builder.append(_xblockexpression_1);
                                {
                                  int _size_2 = contGlobalCall.getParams().size();
                                  boolean _lessThan = (((i).intValue() + 1) < _size_2);
                                  if (_lessThan) {
                                    _builder.append(", ");
                                  }
                                }
                              }
                            }
                            {
                              int _size_3 = ((OperationGlobal)platformOp).getParams().size();
                              ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_3, true);
                              for(final Integer z : _doubleDotLessThan_2) {
                                {
                                  DSLTypeRef _type = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getType();
                                  if ((_type instanceof DSLConcreteTypeRef)) {
                                    String _xblockexpression_2 = null;
                                    {
                                      verif = 0;
                                      _xblockexpression_2 = "";
                                    }
                                    _builder.append(_xblockexpression_2);
                                    {
                                      int _size_4 = contGlobalCall.getParams().size();
                                      ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_4, true);
                                      for(final Integer y : _doubleDotLessThan_3) {
                                        {
                                          boolean _equals_2 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString().equals(contGlobalCall.getParams().get((y).intValue()).getName());
                                          if (_equals_2) {
                                            String _xblockexpression_3 = null;
                                            {
                                              verif = 1;
                                              _xblockexpression_3 = "";
                                            }
                                            _builder.append(_xblockexpression_3);
                                          }
                                        }
                                      }
                                    }
                                    {
                                      if ((verif != 1)) {
                                        {
                                          if (((countComma > 0) && ((z).intValue() >= 1))) {
                                            _builder.append(", ");
                                          }
                                        }
                                        {
                                          Type _ref = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getRef();
                                          boolean _tripleNotEquals = (_ref != null);
                                          if (_tripleNotEquals) {
                                            String _firstUpper = StringExtensions.toFirstUpper(this.compileType(((OperationGlobal)platformOp).getParams().get((z).intValue()).getType()));
                                            _builder.append(_firstUpper);
                                            _builder.append("<");
                                            String _compileConcreteTypes = this.compileConcreteTypes(((OperationGlobal)platformOp).getParams().get((z).intValue()).getRef());
                                            _builder.append(_compileConcreteTypes);
                                            _builder.append("> ");
                                            String _string_3 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString();
                                            _builder.append(_string_3);
                                          } else {
                                            String _compileType_2 = this.compileType(((OperationGlobal)platformOp).getParams().get((z).intValue()).getType());
                                            _builder.append(_compileType_2);
                                            _builder.append(" ");
                                            String _string_4 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString();
                                            _builder.append(_string_4);
                                          }
                                        }
                                        {
                                          int _size_5 = ((OperationGlobal)platformOp).getParams().size();
                                          boolean _lessThan_1 = (((z).intValue() + 1) < _size_5);
                                          if (_lessThan_1) {
                                            _builder.append(", ");
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            _builder.append("){");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("public ");
                            String _compileType_3 = this.compileType(contGlobalCall.getTypeGlobal());
                            _builder.append(_compileType_3);
                            {
                              Type _genericTypesDecl = contGlobalCall.getGenericTypesDecl();
                              boolean _tripleNotEquals_1 = (_genericTypesDecl != null);
                              if (_tripleNotEquals_1) {
                                _builder.append("<");
                                String _name_2 = contGlobalCall.getGenericTypesDecl().getName();
                                _builder.append(_name_2);
                                _builder.append(">");
                              }
                            }
                            {
                              String _col1_1 = ((OperationGlobal)platformOp).getCol1();
                              boolean _tripleEquals_2 = (_col1_1 == null);
                              boolean _not_1 = (!_tripleEquals_2);
                              if (_not_1) {
                                _builder.append("[]");
                              }
                            }
                            _builder.append(" ");
                            String _string_5 = ((OperationGlobal)platformOp).getOpGlobal().getName().toString();
                            _builder.append(_string_5);
                            _builder.append("(");
                            {
                              int _size_6 = contGlobalCall.getParams().size();
                              ExclusiveRange _doubleDotLessThan_4 = new ExclusiveRange(0, _size_6, true);
                              for(final Integer i_1 : _doubleDotLessThan_4) {
                                String _compileType_4 = this.compileType(contGlobalCall.getParams().get((i_1).intValue()).getType());
                                String _plus_2 = (_compileType_4 + " ");
                                String _name_3 = contGlobalCall.getParams().get((i_1).intValue()).getName();
                                String _plus_3 = (_plus_2 + _name_3);
                                _builder.append(_plus_3);
                                String _xblockexpression_4 = null;
                                {
                                  countComma = 1;
                                  _xblockexpression_4 = "";
                                }
                                _builder.append(_xblockexpression_4);
                                {
                                  int _size_7 = contGlobalCall.getParams().size();
                                  boolean _lessThan_2 = (((i_1).intValue() + 1) < _size_7);
                                  if (_lessThan_2) {
                                    _builder.append(", ");
                                  }
                                }
                              }
                            }
                            {
                              int _size_8 = ((OperationGlobal)platformOp).getParams().size();
                              ExclusiveRange _doubleDotLessThan_5 = new ExclusiveRange(0, _size_8, true);
                              for(final Integer z_1 : _doubleDotLessThan_5) {
                                {
                                  DSLTypeRef _type_1 = ((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getType();
                                  if ((_type_1 instanceof DSLConcreteTypeRef)) {
                                    String _xblockexpression_5 = null;
                                    {
                                      verif = 0;
                                      _xblockexpression_5 = "";
                                    }
                                    _builder.append(_xblockexpression_5);
                                    {
                                      int _size_9 = contGlobalCall.getParams().size();
                                      ExclusiveRange _doubleDotLessThan_6 = new ExclusiveRange(0, _size_9, true);
                                      for(final Integer y_1 : _doubleDotLessThan_6) {
                                        {
                                          boolean _equals_3 = ((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getName().toString().equals(contGlobalCall.getParams().get((y_1).intValue()).getName());
                                          if (_equals_3) {
                                            String _xblockexpression_6 = null;
                                            {
                                              verif = 1;
                                              _xblockexpression_6 = "";
                                            }
                                            _builder.append(_xblockexpression_6);
                                          }
                                        }
                                      }
                                    }
                                    {
                                      if ((verif != 1)) {
                                        {
                                          if (((countComma > 0) && ((z_1).intValue() >= 1))) {
                                            _builder.append(", ");
                                          }
                                        }
                                        {
                                          Type _ref_1 = ((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getRef();
                                          boolean _tripleNotEquals_2 = (_ref_1 != null);
                                          if (_tripleNotEquals_2) {
                                            String _firstUpper_1 = StringExtensions.toFirstUpper(this.compileType(((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getType()));
                                            _builder.append(_firstUpper_1);
                                            _builder.append("<");
                                            String _compileConcreteTypes_1 = this.compileConcreteTypes(((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getRef());
                                            _builder.append(_compileConcreteTypes_1);
                                            _builder.append("> ");
                                            String _string_6 = ((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getName().toString();
                                            _builder.append(_string_6);
                                          } else {
                                            String _compileType_5 = this.compileType(((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getType());
                                            _builder.append(_compileType_5);
                                            _builder.append(" ");
                                            String _string_7 = ((OperationGlobal)platformOp).getParams().get((z_1).intValue()).getName().toString();
                                            _builder.append(_string_7);
                                          }
                                        }
                                        {
                                          int _size_10 = ((OperationGlobal)platformOp).getParams().size();
                                          boolean _lessThan_3 = (((z_1).intValue() + 1) < _size_10);
                                          if (_lessThan_3) {
                                            _builder.append(", ");
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                            _builder.append("){");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        {
                          EList<CommandOperation> _cmdList_1 = contGlobalCall.getCmdList();
                          for(final CommandOperation cmdCont : _cmdList_1) {
                            {
                              if ((cmdCont instanceof StringTemplateFreeCod)) {
                                CharSequence _compileStringTemplateFreeCodPlatEntityGlobal = this.compileStringTemplateFreeCodPlatEntityGlobal(((StringTemplateFreeCod)cmdCont).getValue().toString());
                                _builder.append(_compileStringTemplateFreeCodPlatEntityGlobal);
                              } else {
                                CharSequence _compileOperationCmd = this.compileOperationCmd(cmdCont);
                                _builder.append(_compileOperationCmd);
                              }
                            }
                          }
                        }
                        _builder.append("\t       ");
                        _builder.newLineIfNotEmpty();
                        {
                          EList<CommandOperation> _cmdList_2 = ((OperationGlobal)platformOp).getCmdList();
                          for(final CommandOperation cmd : _cmdList_2) {
                            {
                              if ((cmd instanceof StringTemplateFreeCod)) {
                                CharSequence _compileStringTemplateFreeCodPlatController = this.compileStringTemplateFreeCodPlatController(((StringTemplateFreeCod)cmd).getValue().toString(), contGlobalCall, ((OperationGlobal)platformOp));
                                _builder.append(_compileStringTemplateFreeCodPlatController);
                              } else {
                                CharSequence _compileOperationCmd_1 = this.compileOperationCmd(cmd);
                                _builder.append(_compileOperationCmd_1);
                              }
                            }
                          }
                        }
                        _builder.newLineIfNotEmpty();
                        _builder.append("}");
                        _builder.newLine();
                        _builder.newLine();
                      }
                    }
                  } else {
                    if ((platformOp instanceof EntityGlobal)) {
                      {
                        EList<CommandOperation> _cmdList_3 = contGlobalCall.getCmdList();
                        for(final CommandOperation cmdCont_1 : _cmdList_3) {
                          {
                            if ((cmdCont_1 instanceof EntityGlobCall)) {
                              {
                                String _name_4 = ((EntityGlobal)platformOp).getOpGlobal().getName();
                                String _name_5 = ((EntityGlobCall)cmdCont_1).getOpGlobCall().getName();
                                boolean _equals_4 = Objects.equal(_name_4, _name_5);
                                if (_equals_4) {
                                  CharSequence _compileEntityGlob = this.compileEntityGlob(((EntityGlobCall)cmdCont_1), PlataformaDaEntidade, resource);
                                  _builder.append(_compileEntityGlob);
                                  _builder.newLineIfNotEmpty();
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence functionGenerationController(final EntityGlobCall entGlobCall) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public void classGenerationController(final Entity e, final Resource resource, final ArrayList<String> listPlat, final ArrayList<String> listFeatures, final ArrayList<String> classNomeOperation, final String[][] classOpSignParamArray2D, final String[][] OpSignPlatArray2D, final ArrayList<String> OpSignPlatlistNome, final String PlataformaDaEntidade, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Entity> _filter = Iterables.<Entity>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Entity.class);
    for (final Entity en : _filter) {
      boolean _equals = this.EntityPlatform.toString().equals(en.getName());
      if (_equals) {
        EList<CommandFeature> _features = en.getFeatures();
        for (final CommandFeature contGlobCall : _features) {
          if ((contGlobCall instanceof OperationGlobCall)) {
            String _string = this._iQualifiedNameProvider.getFullyQualifiedName(e).toString("/");
            String _compileConcreteTypes = this.compileConcreteTypes(((OperationGlobCall)contGlobCall).getConcreteTypes().get(0));
            String _plus = (_string + _compileConcreteTypes);
            String _plus_1 = (_plus + "Fragment.java");
            fsa.generateFile(_plus_1, 
              this.compileEntityController(e, resource, this.listPlatform, this.listFeat, classNomeOperation, classOpSignParamArray2D, OpSignPlatArray2D, OpSignPlatlistNome, PlataformaDaEntidade, fsa, context, ((OperationGlobCall)contGlobCall)));
          }
        }
      }
    }
  }
  
  public CharSequence compileEntityController(final Entity e, final Resource resource, final ArrayList<String> listPlat, final ArrayList<String> listFeatures, final ArrayList<String> classNomeOperation, final String[][] classOpSignParamArray2D, final String[][] OpSignPlatArray2D, final ArrayList<String> OpSignPlatlistNome, final String PlataformaDaEntidade, final IFileSystemAccess2 fsa, final IGeneratorContext context, final OperationGlobCall contGlobCall) {
    StringConcatenation _builder = new StringConcatenation();
    Boolean PlatEntity = Boolean.valueOf(false);
    _builder.newLineIfNotEmpty();
    {
      QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(e.eContainer());
      boolean _tripleNotEquals = (_fullyQualifiedName != null);
      if (_tripleNotEquals) {
        _builder.append("package ");
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(e.eContainer());
        _builder.append(_fullyQualifiedName_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name = e.getName();
    _builder.append(_name);
    String _compileConcreteTypes = this.compileConcreteTypes(contGlobCall.getConcreteTypes().get(0));
    _builder.append(_compileConcreteTypes);
    _builder.append("Fragment ");
    {
      Entity _superType = e.getSuperType();
      boolean _tripleNotEquals_1 = (_superType != null);
      if (_tripleNotEquals_1) {
        _builder.append(" extends ");
        QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(e.getSuperType());
        _builder.append(_fullyQualifiedName_2);
        _builder.append(" ");
      }
    }
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<CommandFeature> _features = e.getFeatures();
      for(final CommandFeature cmd : _features) {
        String _xblockexpression = null;
        {
          PlatEntity = Boolean.valueOf(false);
          _xblockexpression = "";
        }
        _builder.append(_xblockexpression);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          if ((cmd instanceof OperationGlobCall)) {
            {
              boolean _equals = this.compileConcreteTypes(contGlobCall.getConcreteTypes().get(0)).equals(this.compileConcreteTypes(((OperationGlobCall)cmd).getConcreteTypes().get(0)));
              if (_equals) {
                CharSequence _compileEntityCmd = this.compileEntityCmd(cmd, e, resource, listPlat, listFeatures, classNomeOperation, classOpSignParamArray2D, OpSignPlatArray2D, OpSignPlatlistNome, PlatEntity, PlataformaDaEntidade, fsa, context);
                _builder.append(_compileEntityCmd);
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            CharSequence _compileEntityCmd_1 = this.compileEntityCmd(cmd, e, resource, listPlat, listFeatures, classNomeOperation, classOpSignParamArray2D, OpSignPlatArray2D, OpSignPlatlistNome, PlatEntity, PlataformaDaEntidade, fsa, context);
            _builder.append(_compileEntityCmd_1);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      Iterable<PlatformDecl> _filter = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), PlatformDecl.class);
      for(final PlatformDecl pe : _filter) {
        {
          String _string = pe.getName().toString();
          String _string_1 = PlataformaDaEntidade.toString();
          boolean _tripleEquals = (_string == _string_1);
          if (_tripleEquals) {
            {
              EList<CommandPlat> _cmdList = pe.getCmdList();
              for(final CommandPlat cmdOpPlat : _cmdList) {
                String _xblockexpression_1 = null;
                {
                  PlatEntity = Boolean.valueOf(true);
                  _xblockexpression_1 = "";
                }
                _builder.append(_xblockexpression_1);
                _builder.newLineIfNotEmpty();
                CharSequence _compilePlatCmd = this.compilePlatCmd(cmdOpPlat, e, resource, listPlat, listFeatures, classNomeOperation, classOpSignParamArray2D, OpSignPlatArray2D, OpSignPlatlistNome, PlatEntity);
                _builder.append(_compilePlatCmd);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileOperationGlob(final OperationGlobCallOld opGlobalEnt, final String PlataformaDaEntidade, final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<PlatformDecl> _filter = Iterables.<PlatformDecl>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), PlatformDecl.class);
      for(final PlatformDecl plat : _filter) {
        {
          String _string = plat.getName().toString();
          boolean _tripleEquals = (_string == PlataformaDaEntidade);
          if (_tripleEquals) {
            {
              EList<CommandPlat> _cmdList = plat.getCmdList();
              for(final CommandPlat platformOp : _cmdList) {
                {
                  if ((platformOp instanceof OperationGlobal)) {
                    {
                      String _string_1 = opGlobalEnt.getOpGlobCall().getName().toString().toString();
                      String _string_2 = ((OperationGlobal)platformOp).getOpGlobal().getName().toString();
                      boolean _equals = Objects.equal(_string_1, _string_2);
                      if (_equals) {
                        int verif = 0;
                        _builder.newLineIfNotEmpty();
                        int countComma = 0;
                        _builder.newLineIfNotEmpty();
                        _builder.newLine();
                        _builder.append("public ");
                        String _compileType = this.compileType(opGlobalEnt.getTypeGlobal());
                        _builder.append(_compileType);
                        {
                          Type _genericTypesDecl = opGlobalEnt.getGenericTypesDecl();
                          boolean _tripleNotEquals = (_genericTypesDecl != null);
                          if (_tripleNotEquals) {
                            _builder.append("<");
                            String _name = opGlobalEnt.getGenericTypesDecl().getName();
                            _builder.append(_name);
                            _builder.append(">");
                          }
                        }
                        {
                          String _col1 = opGlobalEnt.getCol1();
                          boolean _tripleEquals_1 = (_col1 == null);
                          boolean _not = (!_tripleEquals_1);
                          if (_not) {
                            _builder.append("[]");
                          }
                        }
                        _builder.append(" ");
                        String _string_3 = opGlobalEnt.getOpGlobCall().getName().toString();
                        _builder.append(_string_3);
                        _builder.append("(");
                        {
                          int _size = opGlobalEnt.getParams().size();
                          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
                          for(final Integer i : _doubleDotLessThan) {
                            String _compileType_1 = this.compileType(opGlobalEnt.getParams().get((i).intValue()).getType());
                            String _plus = (_compileType_1 + " ");
                            String _name_1 = opGlobalEnt.getParams().get((i).intValue()).getName();
                            String _plus_1 = (_plus + _name_1);
                            _builder.append(_plus_1);
                            String _xblockexpression = null;
                            {
                              countComma = 1;
                              _xblockexpression = "";
                            }
                            _builder.append(_xblockexpression);
                            {
                              int _size_1 = opGlobalEnt.getParams().size();
                              boolean _lessThan = (((i).intValue() + 1) < _size_1);
                              if (_lessThan) {
                                _builder.append(", ");
                              }
                            }
                          }
                        }
                        {
                          int _size_2 = ((OperationGlobal)platformOp).getParams().size();
                          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
                          for(final Integer z : _doubleDotLessThan_1) {
                            {
                              DSLTypeRef _type = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getType();
                              if ((_type instanceof DSLConcreteTypeRef)) {
                                String _xblockexpression_1 = null;
                                {
                                  verif = 0;
                                  _xblockexpression_1 = "";
                                }
                                _builder.append(_xblockexpression_1);
                                {
                                  int _size_3 = opGlobalEnt.getParams().size();
                                  ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_3, true);
                                  for(final Integer y : _doubleDotLessThan_2) {
                                    {
                                      boolean _equals_1 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString().equals(opGlobalEnt.getParams().get((y).intValue()).getName());
                                      if (_equals_1) {
                                        String _xblockexpression_2 = null;
                                        {
                                          verif = 1;
                                          _xblockexpression_2 = "";
                                        }
                                        _builder.append(_xblockexpression_2);
                                      }
                                    }
                                  }
                                }
                                {
                                  if ((verif != 1)) {
                                    {
                                      if (((countComma > 0) && ((z).intValue() >= 1))) {
                                        _builder.append(", ");
                                      }
                                    }
                                    {
                                      Type _ref = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getRef();
                                      boolean _tripleNotEquals_1 = (_ref != null);
                                      if (_tripleNotEquals_1) {
                                        String _firstUpper = StringExtensions.toFirstUpper(this.compileType(((OperationGlobal)platformOp).getParams().get((z).intValue()).getType()));
                                        _builder.append(_firstUpper);
                                        _builder.append("<");
                                        String _compileConcreteTypes = this.compileConcreteTypes(((OperationGlobal)platformOp).getParams().get((z).intValue()).getRef());
                                        _builder.append(_compileConcreteTypes);
                                        _builder.append("> ");
                                        String _string_4 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString();
                                        _builder.append(_string_4);
                                      } else {
                                        String _compileType_2 = this.compileType(((OperationGlobal)platformOp).getParams().get((z).intValue()).getType());
                                        _builder.append(_compileType_2);
                                        _builder.append(" ");
                                        String _string_5 = ((OperationGlobal)platformOp).getParams().get((z).intValue()).getName().toString();
                                        _builder.append(_string_5);
                                      }
                                    }
                                    {
                                      int _size_4 = ((OperationGlobal)platformOp).getParams().size();
                                      boolean _lessThan_1 = (((z).intValue() + 1) < _size_4);
                                      if (_lessThan_1) {
                                        _builder.append(", ");
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        _builder.append("){");
                        _builder.newLineIfNotEmpty();
                        {
                          EList<CommandOperation> _cmdList_1 = ((OperationGlobal)platformOp).getCmdList();
                          for(final CommandOperation cmd : _cmdList_1) {
                            {
                              if ((cmd instanceof StringTemplateFreeCod)) {
                                CharSequence _compileStringTemplateFreeCodPlat = this.compileStringTemplateFreeCodPlat(((StringTemplateFreeCod)cmd).getValue().toString(), opGlobalEnt, ((OperationGlobal)platformOp));
                                _builder.append(_compileStringTemplateFreeCodPlat);
                                _builder.newLineIfNotEmpty();
                              } else {
                                CharSequence _compileOperationCmd = this.compileOperationCmd(cmd);
                                _builder.append(_compileOperationCmd);
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                        _builder.append("}");
                        _builder.newLine();
                        _builder.newLine();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileStringTemplateFreeCodPlat(final String opStr, final OperationGlobCallOld opGCall, final OperationGlobal opGlobal) {
    StringConcatenation _builder = new StringConcatenation();
    int _length = opStr.toString().length();
    final int TamString = (_length - 4);
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = opStr.toString().equals("[]");
      boolean _not = (!_equals);
      if (_not) {
        String _generateMethodBody = VelocityGenerator.generateMethodBody(opGCall, opGlobal, opStr.toString().substring(4, TamString));
        _builder.append(_generateMethodBody);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compileStringTemplateFreeCodPlatController(final String opStr, final OperationGlobCall opGCall, final OperationGlobal opGlobal) {
    StringConcatenation _builder = new StringConcatenation();
    int _length = opStr.toString().length();
    final int TamString = (_length - 4);
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = opStr.toString().equals("[]");
      boolean _not = (!_equals);
      if (_not) {
        String _generateMethodBodyController = VelocityGenerator.generateMethodBodyController(opGCall, opGlobal, opStr.toString().substring(4, TamString));
        _builder.append(_generateMethodBodyController);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compileStringTemplateFreeCodPlatEntityGlobal(final String opStr) {
    StringConcatenation _builder = new StringConcatenation();
    int _length = opStr.toString().length();
    final int TamString = (_length - 4);
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = opStr.toString().equals("[]");
      boolean _not = (!_equals);
      if (_not) {
        String _generateMethodBodyEntityGlobal = VelocityGenerator.generateMethodBodyEntityGlobal(opStr.toString().substring(4, TamString));
        _builder.append(_generateMethodBodyEntityGlobal);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compileStringTemplateFreeEntityGlobal(final String opStr, final EntityGlobCall entGCall, final EntityGlobal entGlobal) {
    StringConcatenation _builder = new StringConcatenation();
    int _length = opStr.toString().length();
    final int TamString = (_length - 4);
    _builder.newLineIfNotEmpty();
    {
      boolean _equals = opStr.toString().equals("[]");
      boolean _not = (!_equals);
      if (_not) {
        String _generateMethodBodyEntity = VelocityGenerator.generateMethodBodyEntity(entGCall, entGlobal, opStr.toString().substring(4, TamString));
        _builder.append(_generateMethodBodyEntity);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compile(final Attribute f) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((Integer.valueOf(f.getArrayAllow()).equals(Integer.valueOf(0)) && (f.getConcreteTypes().size() == 0))) {
        _builder.append(" ");
        _builder.append("private ");
        Comparable<?> _specificReturnVariable = this.specificReturnVariable(f);
        _builder.append(_specificReturnVariable);
        _builder.append(" ");
        String _name = f.getName();
        _builder.append(_name);
        _builder.append(";\t\t");
        _builder.newLineIfNotEmpty();
      } else {
        if (((!Integer.valueOf(f.getArrayAllow()).equals(Integer.valueOf(0))) && (f.getConcreteTypes().size() == 0))) {
          _builder.append(" ");
          _builder.append("private ");
          QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
          _builder.append(_fullyQualifiedName);
          _builder.append("[] ");
          String _name_1 = f.getName();
          _builder.append(_name_1);
          _builder.append(" = new ");
          QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
          _builder.append(_fullyQualifiedName_1);
          _builder.append("[");
          int _arrayAllow = f.getArrayAllow();
          _builder.append(_arrayAllow);
          _builder.append("];");
          _builder.newLineIfNotEmpty();
        } else {
          int _size = f.getConcreteTypes().size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append(" ");
            _builder.append("private ");
            String _name_2 = f.getType().getName();
            _builder.append(_name_2);
            _builder.append("<");
            String _countAttributeConcrete = this.countAttributeConcrete(f);
            _builder.append(_countAttributeConcrete);
            _builder.append("> ");
            String _name_3 = f.getName();
            _builder.append(_name_3);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      int _size_1 = f.getConcreteTypes().size();
      boolean _equals = (_size_1 == 0);
      if (_equals) {
        _builder.append(" ");
        _builder.append("public ");
        Comparable<?> _specificReturnVariable_1 = this.specificReturnVariable(f);
        _builder.append(_specificReturnVariable_1);
        {
          boolean _equals_1 = Integer.valueOf(f.getArrayAllow()).equals(Integer.valueOf(0));
          boolean _not = (!_equals_1);
          if (_not) {
            _builder.append("[]");
          }
        }
        _builder.append(" get");
        String _firstUpper = StringExtensions.toFirstUpper(f.getName());
        _builder.append(_firstUpper);
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append(" ");
        _builder.append("return ");
        String _name_4 = f.getName();
        _builder.append(_name_4);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("}");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append(" ");
        _builder.append("public void set");
        String _firstUpper_1 = StringExtensions.toFirstUpper(f.getName());
        _builder.append(_firstUpper_1);
        _builder.append("(");
        Comparable<?> _specificReturnVariable_2 = this.specificReturnVariable(f);
        _builder.append(_specificReturnVariable_2);
        {
          boolean _equals_2 = Integer.valueOf(f.getArrayAllow()).equals(Integer.valueOf(0));
          boolean _not_1 = (!_equals_2);
          if (_not_1) {
            _builder.append("[]");
          }
        }
        _builder.append(" ");
        String _name_5 = f.getName();
        _builder.append(_name_5);
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append(" ");
        _builder.append("this.");
        String _name_6 = f.getName();
        _builder.append(_name_6);
        _builder.append(" = ");
        String _name_7 = f.getName();
        _builder.append(_name_7);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("}");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public Comparable<?> specificReturnVariable(final Attribute f) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
    String _plus = (" f.type.fullyQualifiedName :" + _fullyQualifiedName);
    InputOutput.<String>println(_plus);
    if (((Objects.equal(StringExtensions.toFirstUpper(this._iQualifiedNameProvider.getFullyQualifiedName(f.getType()).toString()).toString(), "Date") || Objects.equal(StringExtensions.toFirstUpper(this._iQualifiedNameProvider.getFullyQualifiedName(f.getType()).toString()).toString(), "DateTime")) || Objects.equal(this._iQualifiedNameProvider.getFullyQualifiedName(f.getType()).toString(), "string"))) {
      return "String";
    } else {
      if ((Objects.equal(this._iQualifiedNameProvider.getFullyQualifiedName(f.getType()).toString(), "bool") || Objects.equal(this._iQualifiedNameProvider.getFullyQualifiedName(f.getType()).toString(), "Bool"))) {
        return "Boolean";
      } else {
        return this._iQualifiedNameProvider.getFullyQualifiedName(f.getType());
      }
    }
  }
  
  public String specificReturnVariableGlogal(final String f) {
    if (((Objects.equal(StringExtensions.toFirstUpper(f.toString()).toString(), "Date") || Objects.equal(StringExtensions.toFirstUpper(f.toString()).toString(), "DateTime")) || Objects.equal(f.toString(), "string"))) {
      return "String";
    } else {
      if ((Objects.equal(f.toString(), "bool") || Objects.equal(f.toString(), "Bool"))) {
        return "Boolean";
      } else {
        return f;
      }
    }
  }
}
