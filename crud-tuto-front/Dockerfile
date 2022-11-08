# Stage 1: Compile and Build angular codebase
#FROM node:12.18-alpine as build
#WORKDIR /app
#COPY . .
#RUN npm install --force
#RUN npm run build
# Stage 2: Serve app with nginx servera
FROM nginx:alpine
COPY dist/crudtuto-Front /usr/share/nginx/html
EXPOSE 4200:80
