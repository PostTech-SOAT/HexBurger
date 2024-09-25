variable "helm_service_template" {
  type = list(object({
    name                 = string
    namespaces           = string
    helm_chart_key_value = map(string)
    config_map_values    = map(string)
  }))
}
variable "application" {}
variable "aws_region" {}
variable "ingress_nginx_name" {}
