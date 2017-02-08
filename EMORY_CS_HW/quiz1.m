x = linspace(-3,3,100); 
f = @(x) x.^3-2*x;
figure(1)
plot(x,f(x),'b','LineWidth',2);
axis([-3 3 -5 5]);
hold on;
x1 = linspace(-2,2,100);
g = @(x1) 2*x1; 
plot(x1,g(x1),'b','LineWidth',2);
axis([-3 3 -5 5]);
hold on;
x3 = linspace(-3,3,100); 
h = @(x3) (2*x3)-(16/(3*(sqrt(3))));
j = @(x3) (2*x3)+(16/(3*(sqrt(3))));
plot(x3,h(x3),'b','LineWidth',2)
hold on;
plot(x3,j(x3),'b','LineWidth',2)
