kubectl apply -f clusterrole.yaml
kubectl apply -f serviceaccount.yaml
kubectl apply -f clusterrolebinding.yaml

kubectl apply -f namespace.yaml
kubectl config set-context --current --namespace=datadog-apm-sample

kubectl create secret generic datadog-secret --from-literal api-key="4a714a6e1e635dd10370674253ca0d25"
kubectl get secret datadog-secret -o yaml 

kubectl apply -f datadog-agent.yaml