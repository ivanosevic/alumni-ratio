# Stage 0, "build-stage", based on Node.js, to build and compile the frontend
FROM node:18.15.0-alpine3.17 as build-stage
WORKDIR /app
COPY nginx.conf /app/
COPY package*.json /app/
RUN npm install
COPY ./ /app/
RUN npm run build
# Stage 1, based on Nginx, to have only the compiled app, ready for production with Nginx
FROM nginx:1.15
COPY --from=build-stage /app/dist/ /usr/share/nginx/html
# Copy the default nginx.conf provided by tiangolo/node-frontend
COPY --from=build-stage /app/nginx.conf /etc/nginx/nginx.conf