package introductionmaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	//@Test
	public void regular()
	{
	//to count the no. of names that starts with alphabet A
			//first create an object for arraylist
			ArrayList<String> names=new ArrayList<String>();//since it has all strings we give as string
			//adding items into arraylist
			names.add("Abhijeet");
			names.add("Don");
			names.add("Alekhya");
			names.add("Adam");
			names.add("Ram");
			int count=0;
			for (int i=0;i<names.size();i++)
			{
				String actual=names.get(i);//everytime when the loop executes it gets the name
				if (actual.startsWith("A"))
				{
					count++;
				}
			}
	      System.out.println(count);
	}

//@Test
public void streamfilter()
{
	//to count the no. of names that starts with alphabet A
	//first create an object for arraylist
	ArrayList<String> names=new ArrayList<String>();//since it has all strings we give as string
	//adding items into arraylist
	names.add("Abhijeet");
	names.add("Don");
	names.add("Alekhya");
	names.add("Adam");
	names.add("Ram");
	// step1 : here first the names arraylist is converted into stream using names.stream() i.e create a stream
	//step2 : perform intermediate operations on initial stream to transform it into another stream
	//here the intermediate operation is filter is applied and it checks for condition starts with A
	//step3:perform terminal operation on the final stream to get the result
	//here it is count and the return type of count is long 
	Long c=names.stream().filter(s->s.startsWith("A")).count();
	System.out.println(c);
	//here the above program can also be written as below both are same
	//there is no life for intermediate operation if there is no terminal operation
	//terminal operation will execute only if intermediate operation i.e filter returns true
	//we can create stream using stream.of()
	Long d=Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->
	{//this braces may/may not be used but here we use it for right side operation of ->
		s.startsWith("A");
		//return false;//here we write return false but the pgm doesnot produce o/p if we write false
		return true;
	}).count();
	System.out.println(d);
	//to print all the names of arraylist whose length>4
	//foreach will Performs an action for each element of this stream.
	names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	//to print only first result whose length()>4
	names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
}
//@Test
public void streammap()
{
	//print names which have last letter as "a" with uppercase
	Stream.of("Abhijeet","Don","Alekhya","Adam","Rama")
	.filter(s->s.endsWith("a"))//first it takes all names nd filter the names that end with "a"
	.map(s->s.toUpperCase())//after filtering mapping is done to convert to uppercase
	.forEach(s->System.out.println(s));//Performs an action for each element of this stream.
	//print names which have first letter as "a" with uppercase nd sorted
	//if we have arrays we can convert array into arraylist using Arrays.aslist()
	List<String> names=Arrays.asList("Azbhijeet","Don","Alekhya","Adam","Rama");
	names.stream()
	.filter(s->s.startsWith("A"))//first it takes all names nd filter the names that starts with "a"
	.sorted()//Returns a stream consisting of the elements of this stream, sortedaccording to natural order.
	.map(s->s.toUpperCase())//after filtering mapping is done to convert to uppercase
	.forEach(s->System.out.println(s));//Performs an action for each element of this stream.
}
//@Test
public void mergearraylist()
{
	//first create an object for arraylist
	ArrayList<String> names=new ArrayList<String>();//since it has all strings we give as string
	//adding items into arraylist
	names.add("man");
	names.add("Don");
	names.add("women");
	//if we have arrays we can convert array into arraylist using Arrays.aslist()
		List<String> names1=Arrays.asList("Azbhijeet","Don","Alekhya","Adam","Rama");
		//to merge the arraylist of strings above
		Stream<String> newstream=Stream.concat(names.stream(), names1.stream());
		//to print new stream
	   //	newstream.forEach(s->System.out.println(s));
		//to print new stream in sorted order
		//newstream.sorted().forEach(s->System.out.println(s));
		//to check whether adam is present in the new stream/not
		boolean flag=newstream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		//to print the true/false in console
		System.out.println(flag);
		//if flag contains true then assert returns true else false
		Assert.assertTrue(flag);
}
//@Test
//perform stream operations and converting them into list is done by using collect() in streams
public void streamcollect()
{
	List<String> ls=Stream.of("Abhijeet","Don","Alekhya","Adam","Rama")
			//Returns a stream consisting of the elements of this stream that matchthe given predicate.
			.filter(s->s.endsWith(s)) 
			//Returns a stream consisting of the results of applying the givenfunction to the elements of this stream
			.map(s->s.toUpperCase())
			//Performs a mutablereduction operation on the elements of this stream using a Collector
			.collect(Collectors.toList());
	System.out.println(ls.get(0));//after converting in to list to print 0th element of list
}
@Test
public void integerstreams()
{
	List<Integer> values=Arrays.asList(3,2,2,7,5,1,9,7);
	//print unique no. from array
		//	values
		//	.stream()//converts values into streams
		//	.distinct()//to take only distinct values
		//.forEach(s->System.out.println(s));//print all in console
	//to sort the array nd to get the 3rd index in list
	List<Integer> li=
			values
			.stream()//converts values into streams
			.distinct()//to take only distinct values
			.sorted()//to arrange the values in sorted order
			.collect(Collectors.toList());//to convert again into list
	//to print all values
	System.out.println(li);
	//to print only the value with index 2
	System.out.println(li.get(2));
}
}

