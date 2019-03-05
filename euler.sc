

[1, 2, 3, 4].reverse

5.dup(20)

// problem #1

// all {:[x], x <- (1..1000), (x % 3 == 0) && (x % 5 == 0) }.sum

(1..1000)
.select({|x| x % 3 == 0})
.select({|x| x % 5 == 0})
.reduce({|a, b| a + b})


// #2

// recursive
f = {|a, b|
	if (a > 4000000)
	{ 0 }
	{ if (a % 2 == 0)
		{ a + f.value(b, a + b) }
		{ f.value(b, a + b) }
	}
}

f.value(1, 2);

// imperative
(
var sum = 0;
var a = 1;
var b = 2;

while ({a < 4000000}, {
	var next = a + b;
	a = b;
	b = next;

	if (a % 2 == 0 )
	{ sum = a + sum ; }
	{}	
});

sum.postln;
)






