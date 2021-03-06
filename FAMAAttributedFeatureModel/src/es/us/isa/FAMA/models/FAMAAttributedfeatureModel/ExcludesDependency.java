/*
	This file is part of FaMaTS.

    FaMaTS is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FaMaTS is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with FaMaTS.  If not, see <http://www.gnu.org/licenses/>.

 */
/*
 * Created on 15-Mar-2005
 */
package es.us.isa.FAMA.models.FAMAAttributedfeatureModel;

import es.us.isa.FAMA.models.featureModel.KeyWords;
import es.us.isa.util.Node;
import es.us.isa.util.Tree;


/**
 * @author trinidad, Manuel Nieto Ucl�s 
 */
public class ExcludesDependency extends Dependency {
	
	public ExcludesDependency(String name){
		super(name);
	}
	
	public ExcludesDependency(AttributedFeature origin, AttributedFeature destination) {		
		super(origin, destination);
	}
	
	public ExcludesDependency(String name, AttributedFeature origin, AttributedFeature destination){
		super(name, origin, destination);
	}
	
	public String toString() {
		String res = origin.getName() + " excludes " + destination.getName();
		return res;
	}

	@Override
	public Tree<String> getAST() {
		//devolvemos el arbol con la restriccion
		//cuidado, debemos negar al destino: a -> �b
		Node<String> r = new Node<String>(KeyWords.EXCLUDES);
		Node<String> o = new Node<String>(this.origin.getName());
		Node<String> d = new Node<String>(this.destination.getName());
//		Node<String> not = new Node<String>(KeyWords.NOT);
//		not.addChild(d);
		r.addChild(o);
		r.addChild(d);
//		r.addChild(not);
		Tree<String> res = new Tree<String>(r);
		return res;
	}
}
