syms x; % x is the symbolic variable
 y = sin(x); % y is the function of x we want to plot
ezplot(y, [0,2*pi]); % plot y(x) from x=0 to x=2*pi
dydx = diff(y); % symbolic variable ’dydx’ is the first derivative of y
m = subs(dydx, x, 2); % m is slope of y(x) at x=2
y0 = subs(y, x, 2); % y0 is value of y(x) at x=2
hold on; % draw the next line on the same graph
ezplot(m*(x-2)+y0, [0,2*pi]); % plot the tangent line at x=2
hold off