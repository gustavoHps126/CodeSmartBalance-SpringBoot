package br.com.cotemig.codesmartbalancespringboot.DTO;

import br.com.cotemig.codesmartbalancespringboot.Component.Pagination;
import br.com.cotemig.codesmartbalancespringboot.Model.User;

import java.util.List;

public record UsersPaginationDTO(List<User> users, Pagination pagination) {
}
