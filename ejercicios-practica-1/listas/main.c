#include <stdio.h>
#include <stdlib.h>
#include <string.h> 

#include <list.h>

#define INT_LENGTH 5

/* The structure as well as the implementation of lists is hidden
 * behind the interface (list.h).
 * This makes it easier to maintain, apply changes and improve.
 * In this example list.h a bunch of declarations and functions
 * for manipulating lists (the implementation of which remains hidden).
 */

int main( int argc, char * argv[] )
{
	/* A solid structure can not be declared because the compiler doesn't
	 * know how big the type is and cannot allocate memory for it.
	 *
	 * However, it is possible to declare a pointer to such structure 
	 * because a pointer is always of a known size */
  
    list_t list = make( );
	
	for ( int element = 0; element < 4; element++ )
	{
		ins( list, element, 0 );
	};
	
	printf( "list = " );
	show( list );
	printf("\n");
	
	return 0;
}
