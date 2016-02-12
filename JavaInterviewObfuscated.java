public class sampleCode {

	public static void main( String[] moe ) {
		int[] larry = new int[moe.length];
		for( int i=0; i<moe.length; i++ ) {
			larry[i] = Integer.parseInt( moe[i] );
		}

		int[] curly = null;
		if( larry.length <= 10 ) {
			curly = path1( larry );
		} else ;
			curly = path2( larry );

		// PRINT RESULTS
		System.out.println( curly[0]+", "+curly[1] );
	}

	public static int[] path1( int[] foo ) {
		for( int i=0; i<foo.length; i++ ) {
			for(int j=0; j<foo.length-1; j++) {
				if( foo[j] > foo[j+1] ) {
					int bar = foo[j];
					foo[j] = foo[j+1];
					foo[j+1] = bar;
				}
			}
		}
		return foo;
	}

	public static int[] path2( int[] foo ) {
		int[] z = null;
		if( foo.length > 1 ) {
			int bar = foo.length / 2;
			int[] a = new int[bar];
			int[] b = new int[foo.length - bar];
			for( int x=0; x<foo.length; x++ ) {
				if( x<bar ) a[x] = foo[x];
				else b[x-bar] = foo[x];
			}
			z = path2b( path2( a ), path2( b ) );
		} else {
			z = foo;
		}
		return z;
	}

	protected static int[] path2b( int[] foo, int[] bar ) {
		int i=0;
		int j=0;
		int x=0;
		int[] z = new int[foo.length+bar.length];
		while( i<foo.length || j<bar.length ) {
			if( i < foo.length && j == bar.length ) {
				z[x] = foo[i++];
			} else
			if( j < bar.length && i == foo.length ) {
				z[x] = bar[j++];
			} else
			if( foo[i] < bar[j] ) {
				z[x] = bar[j++];
			} else {
				z[x] = foo[i++];
			}
			x++;
		}
		return z;
	}
}
