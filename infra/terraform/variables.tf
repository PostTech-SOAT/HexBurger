variable "helm_service_template" {
  type = list(object({
    name                 = string
    namespaces           = string
    helm_chart_key_value = map(string)
    config_map_values    = map(string)
  }))
}
variable "application" {
  type = string
}
variable "aws_region" {
  type = string
}
variable "ingress_nginx_name" {
  type = string
}
variable "kubernetes_config_map" {
  type = map(string)
}
variable "kubernetes_secrets_data" {
  type = map(string)
}
variable "is_there_config_map" {
  type = bool
}
variable "is_there_secret" {
  type = bool
}
