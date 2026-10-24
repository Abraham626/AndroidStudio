# Mini guía de Git

## git status
Muestra el estado de tu proyecto: qué archivos has cambiado y cuáles están listos para subir.

```
git status
```

## git add
Prepara los archivos para el commit. El punto `.` significa "todos los archivos".

```
git add .
```

## git commit
Guarda los cambios preparados con un mensaje que explique qué has hecho.

```
git commit -m "mensaje del cambio"
```

## git push
Sube tus commits a GitHub.

```
git push
```

## Orden normal para subir cambios

```
git status
git add .
git commit -m "mensaje del cambio"
git push
```

**Nota:** si es la primera vez que subes un repositorio nuevo, usa `git push -u origin main`.