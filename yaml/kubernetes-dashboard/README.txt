$ kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-rc7/aio/deploy/recommended.yaml

kubectl get secret -n kubernetes-dashboard 

$TOKEN=((kubectl describe secret secret-name -n kubernetes-dashboard | Sls "token:") -split " +")[1] 

kubectl config set-credentials --token=${TOKEN} 

$ kubectl proxy

http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/.