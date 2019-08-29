/**
 *
 * Copyright (c) 2014, the Railo Company Ltd. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either 
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this library.  If not, see <http://www.gnu.org/licenses/>.
 * 
 **/
/**
 * Implements the CFML Function isdate
 */
package org.lucee.extension.pdf.function;

import org.lucee.extension.pdf.util.PDFUtil;

import lucee.loader.engine.CFMLEngineFactory;
import lucee.runtime.PageContext;
import lucee.runtime.exp.PageException;
import lucee.runtime.ext.function.BIF;
import lucee.runtime.ext.function.Function;

public final class IsPDFObject extends BIF implements Function {

	private static final long serialVersionUID = 2871560443450837918L;

	public static boolean call(PageContext pc, Object value) {
		try {
			PDFUtil.toPdfReader(pc, value, null);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Object invoke(PageContext pc, Object[] args) throws PageException {
		if (args.length != 1) throw CFMLEngineFactory.getInstance().getExceptionUtil().createFunctionException(pc, "IsPDFObject", 1, 1, args.length);

		return call(pc, args[0]);
	}
}