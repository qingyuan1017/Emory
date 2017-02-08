t = linspace(0,3*pi,100); % 50 equally spaced points between 0 and pi
x = t.*cos(t);     % Again, the .* means multiply element by element
y = t.*sin(t);     % rather than matrix or vector multiplication
plot(x,y)
axis equal % Make the scaling the same on both axes