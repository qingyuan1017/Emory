x = linspace (-6,6,200);
y = linspace (-6,6,200);
[X,Y] = meshgrid(x,y);
f = @(X,Y) sin(X).*cos(Y);

z = f(X,Y);
figure(1)
mesh (X,Y,z)
figure(2)
contour(X,Y,z,50)