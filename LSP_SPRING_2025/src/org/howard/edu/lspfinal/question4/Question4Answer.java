// Course Materials

package org.howard.edu.lspfinal.question4;

	/*
	In our lectures, we learned that design patterns can add flexibility and avoid repeating ourselves—but 
	they’re not always the right tool. When a process is simple and guaranteed not to change, forcing it into 
	a formal pattern just buries clear logic under extra layers. For example, if we have a fixed three-step 
	report (load data, format it, print it) that will never vary, wrapping it in a Template Method setup makes 
	us create an abstract base class, abstract hook methods, and a concrete subclass that never really does 
	anything different. We end up maintaining multiple files and jumping through indirection for zero benefit.
	
	As discussed on the class, patterns can actually make a design harder to read 
	and maintain if there’s nothing that varies . It also goes against the KISS principle (“Keep It Simple, Stupid”) 
	we discussed when talking about Strategy and Adapter: adding abstractions where they aren’t needed violates the 
	idea of keeping code straightforward and focused . In those cases, it’s better for us to write the direct 
	implementation and only refactor into a pattern later if real variability or extension points appear.
	*/

public class Question4Answer {
    // no code needed—this class just holds our comment above
}
